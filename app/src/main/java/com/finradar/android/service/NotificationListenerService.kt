package com.finradar.android.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NotificationListenerService : NotificationListenerService() {

    @Inject
    lateinit var processNotificationUseCase: dagger.Lazy<com.finradar.android.domain.usecase.ProcessNotificationUseCase>

    // Coroutine scope for database operations
    private val serviceScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun onListenerConnected() {
        super.onListenerConnected()
        Log.d("NotificationListener", "Service connected")
        android.os.Handler(android.os.Looper.getMainLooper()).post {
            android.widget.Toast.makeText(this@NotificationListenerService, "Okuyucu Bağlandı (Aktif)!", android.widget.Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        sbn?.let { notification ->
            val extras = notification.notification.extras
            val title = extras.getCharSequence("android.title")?.toString() ?: ""
            val text = extras.getCharSequence("android.text")?.toString() ?: ""
            val packageName = notification.packageName
            
            // Log for debugging
            Log.d("FinRadar", "Notification: $packageName - $title - $text")

            android.os.Handler(android.os.Looper.getMainLooper()).post {
                android.widget.Toast.makeText(this@NotificationListenerService, "Test: [$title] yakalandı!", android.widget.Toast.LENGTH_SHORT).show()
            }

            serviceScope.launch {
                try {
                    processNotificationUseCase.get()(packageName, title, text, notification.postTime)
                } catch (e: Exception) {
                    Log.e("FinRadar", "Hata", e)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
    }
}
