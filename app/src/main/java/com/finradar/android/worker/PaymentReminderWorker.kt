package com.finradar.android.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.finradar.android.data.preferences.UserPreferencesRepository
import com.finradar.android.domain.model.Alert
import com.finradar.android.domain.model.AlertType
import com.finradar.android.domain.repository.AlertRepository
import com.finradar.android.domain.repository.SubscriptionRepository
import com.finradar.android.notification.NotificationHelper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first
import java.util.concurrent.TimeUnit

@HiltWorker
class PaymentReminderWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParams: WorkerParameters,
    private val subscriptionRepository: SubscriptionRepository,
    private val prefsRepository: UserPreferencesRepository,
    private val alertRepository: AlertRepository
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val reminderDays = prefsRepository.reminderDays.first().toLong()
            val subscriptions = subscriptionRepository.getActiveSubscriptions().first()
            val today = System.currentTimeMillis()

            val withDate = subscriptions.filter { it.nextPaymentDate > 0 }
            withDate.forEach { sub ->
                val daysUntil = TimeUnit.MILLISECONDS.toDays(sub.nextPaymentDate - today)

                if (daysUntil in 0..reminderDays) {
                    // Unique check: don't send if already sent today
                    if (alertRepository.hasReminderBeenSentToday(sub.id)) {
                        return@forEach
                    }

                    NotificationHelper.sendPaymentReminder(
                        context          = context,
                        subscriptionId   = sub.id,
                        subscriptionName = sub.name,
                        amount           = sub.averageAmount,
                        daysLeft         = daysUntil
                    )
                    alertRepository.saveAlert(
                        Alert(
                            subscriptionId   = sub.id,
                            subscriptionName = sub.name,
                            oldAmount        = sub.averageAmount,
                            newAmount        = sub.averageAmount,
                            percentageChange = 0.0,
                            isRead           = false,
                            date             = today,
                            type             = AlertType.PAYMENT_REMINDER
                        )
                    )
                }
            }
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}
