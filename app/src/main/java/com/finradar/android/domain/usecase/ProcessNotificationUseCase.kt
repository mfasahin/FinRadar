package com.finradar.android.domain.usecase

import com.finradar.android.data.parser.NotificationParser
import com.finradar.android.domain.repository.AlertRepository
import com.finradar.android.domain.repository.PendingSubscriptionRepository
import com.finradar.android.domain.repository.SubscriptionRepository
import com.finradar.android.domain.repository.TransactionRepository
import javax.inject.Inject

class ProcessNotificationUseCase @Inject constructor(
    private val notificationParser: NotificationParser,
    private val transactionRepository: TransactionRepository,
    private val subscriptionRepository: SubscriptionRepository,
    private val pendingSubscriptionRepository: PendingSubscriptionRepository,
    private val alertRepository: AlertRepository,
    private val subscriptionDetector: SubscriptionDetector,
    private val priceHikeDetector: PriceHikeDetector
) {
    suspend operator fun invoke(packageName: String, title: String, text: String, timestamp: Long) {
        val transaction = notificationParser.parseNotification(packageName, title, text, timestamp) ?: return
        
        transactionRepository.saveTransaction(transaction)
        
        // Detect Subscription
        val potentialSubscription = subscriptionDetector.detectSubscription(transaction)
        
        if (potentialSubscription != null) {
            val existingSubscription = subscriptionRepository.getSubscriptionByName(potentialSubscription.name)
            
            if (existingSubscription == null) {
                // New subscription: ask user before saving (store as pending, UI will show dialog)
                pendingSubscriptionRepository.setPendingSubscription(potentialSubscription)
            } else {
                // Existing Subscription - Check for Price Hike
                val alert = priceHikeDetector.checkPriceHike(transaction, existingSubscription)
                if (alert != null) {
                    alertRepository.saveAlert(alert)
                }
                
                // Update existing subscription stats
                val updatedSubscription = existingSubscription.copy(
                    lastPaymentDate = transaction.date,
                    averageAmount = (existingSubscription.averageAmount + transaction.amount) / 2
                )
                subscriptionRepository.saveSubscription(updatedSubscription)
            }
        }
    }
}
