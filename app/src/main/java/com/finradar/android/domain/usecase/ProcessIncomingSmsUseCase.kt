package com.finradar.android.domain.usecase

import com.finradar.android.data.parser.SmsParser
import com.finradar.android.domain.repository.AlertRepository
import com.finradar.android.domain.repository.SubscriptionRepository
import com.finradar.android.domain.repository.TransactionRepository
import javax.inject.Inject

class ProcessIncomingSmsUseCase @Inject constructor(
    private val smsParser: SmsParser,
    private val transactionRepository: TransactionRepository,
    private val subscriptionRepository: SubscriptionRepository,
    private val alertRepository: AlertRepository,
    private val subscriptionDetector: SubscriptionDetector,
    private val priceHikeDetector: PriceHikeDetector
) {
    suspend operator fun invoke(sender: String, message: String, timestamp: Long) {
        val transaction = smsParser.parseSms(sender, message, timestamp) ?: return
        
        transactionRepository.saveTransaction(transaction)
        
        // Detect Subscription
        val potentialSubscription = subscriptionDetector.detectSubscription(transaction)
        
        if (potentialSubscription != null) {
            val existingSubscription = subscriptionRepository.getSubscriptionByName(potentialSubscription.name)
            
            if (existingSubscription == null) {
                // New Subscription!
                subscriptionRepository.saveSubscription(potentialSubscription)
            } else {
                // Existing Subscription - Check for Price Hike
                val alert = priceHikeDetector.checkPriceHike(transaction, existingSubscription)
                if (alert != null) {
                    alertRepository.saveAlert(alert)
                }
                
                // Update existing subscription stats (simple update for MVP)
                val updatedSubscription = existingSubscription.copy(
                    lastPaymentDate = transaction.date,
                    averageAmount = (existingSubscription.averageAmount + transaction.amount) / 2
                )
                subscriptionRepository.saveSubscription(updatedSubscription)
            }
        }
    }
}
