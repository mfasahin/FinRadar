package com.finradar.android.worker

import android.content.Context
import android.util.Log
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

    companion object {
        private const val TAG = "PaymentReminderWorker"
    }

    override suspend fun doWork(): Result {
        Log.d(TAG, "doWork() started")
        return try {
            val reminderDays = prefsRepository.reminderDays.first().toLong()
            Log.d(TAG, "reminderDays = $reminderDays")

            val subscriptions = subscriptionRepository.getActiveSubscriptions().first()
            Log.d(TAG, "total active subscriptions = ${subscriptions.size}")

            val today = System.currentTimeMillis()

            val withDate = subscriptions.filter { it.nextPaymentDate > 0 }
            Log.d(TAG, "subscriptions with nextPaymentDate set = ${withDate.size}")

            withDate.forEach { sub ->
                val daysUntil = TimeUnit.MILLISECONDS.toDays(sub.nextPaymentDate - today)
                Log.d(TAG, "${sub.name}: nextPaymentDate=${sub.nextPaymentDate}, daysUntil=$daysUntil, window=0..$reminderDays")

                if (daysUntil in 0..reminderDays) {
                    Log.d(TAG, "→ SENDING notification for ${sub.name}")
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
                    Log.d(TAG, "→ Alert saved to DB for ${sub.name}")
                } else {
                    Log.d(TAG, "→ SKIPPED (daysUntil=$daysUntil not in 0..$reminderDays)")
                }
            }
            Log.d(TAG, "doWork() completed successfully")
            Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "doWork() FAILED with exception: ${e.message}", e)
            Result.retry()
        }
    }
}
