package com.finradar.android.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.finradar.android.MainActivity
import com.finradar.android.R
import java.text.NumberFormat
import java.util.Locale

object NotificationHelper {

    private const val CHANNEL_ID   = "payment_reminders"
    private const val CHANNEL_NAME = "Ödeme Hatırlatıcıları"

    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Yaklaşan abonelik ödemesi bildirimleri"
            }
            val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(channel)
        }
    }

    fun sendPaymentReminder(
        context: Context,
        subscriptionId: Long,
        subscriptionName: String,
        amount: Double,
        daysLeft: Long
    ) {
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val amountStr = NumberFormat.getCurrencyInstance(Locale("tr", "TR")).format(amount)

        val title = context.getString(R.string.notif_reminder_title, subscriptionName)
        val body  = when {
            daysLeft <= 0L -> context.getString(R.string.notif_reminder_today, amountStr)
            daysLeft == 1L -> context.getString(R.string.notif_reminder_tomorrow, amountStr)
            else           -> context.getString(R.string.notif_reminder_days, daysLeft, amountStr)
        }

        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(context.applicationInfo.icon)
            .setContentTitle(title)
            .setContentText(body)
            .setStyle(NotificationCompat.BigTextStyle().bigText(body))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        nm.notify(subscriptionId.toInt(), notification)
    }
}
