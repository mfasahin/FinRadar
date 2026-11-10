package com.finradar.android

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import androidx.work.*
import com.finradar.android.notification.NotificationHelper
import com.finradar.android.presentation.navigation.FinRadarNavGraph
import com.finradar.android.presentation.settings.SettingsViewModel
import com.finradar.android.ui.theme.FinRadarTheme
import com.finradar.android.worker.PaymentReminderWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import com.finradar.android.data.preferences.UserPreferencesRepository
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface PrefsEntryPoint {
    fun userPreferencesRepository(): UserPreferencesRepository
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun attachBaseContext(newBase: Context) {
        val langCode = newBase.getSharedPreferences("lang_pref", Context.MODE_PRIVATE)
            .getString("lang", "tr") ?: "tr"
        val locale = Locale(langCode)
        Locale.setDefault(locale)
        val config = Configuration(newBase.resources.configuration)
        config.setLocale(locale)
        super.attachBaseContext(newBase.createConfigurationContext(config))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bildirim kanalını oluştur & Android 13+'ta izin iste
        NotificationHelper.createChannel(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
        ) {
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {}
                .launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        // Günlük ödeme hatırlatıcısını öğlen 12:00'de tetiklenecek şekilde planla
        schedulePaymentReminders()

        setContent {
            val isDark by settingsViewModel.isDarkTheme.collectAsState()

            FinRadarTheme(isDark = isDark) {
                val navController = rememberNavController()
                FinRadarNavGraph(navController = navController)
            }
        }
    }

    /**
     * Günlük ödeme hatırlatıcı worker'ını planlar.
     * İlk tetiklenme bir sonraki öğlen 12:00'e hesaplanır;
     * sonrasında tam 24 saatte bir çalışır.
     */
    private fun schedulePaymentReminders() {
        val delayMs = millisUntilNextNoon()

        val workRequest = PeriodicWorkRequestBuilder<PaymentReminderWorker>(1, TimeUnit.DAYS)
            .setInitialDelay(delayMs, TimeUnit.MILLISECONDS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiresBatteryNotLow(true)
                    .build()
            )
            .build()

        // UPDATE: mevcut iş varsa yeni zamanlamayı uygula
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "payment_reminders",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequest
        )
    }

    /** Şu andan bir sonraki öğlen 12:00'e kadar geçen milisaniye. */
    private fun millisUntilNextNoon(): Long {
        val now = Calendar.getInstance()
        val noon = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 12)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            // Bugünkü öğlen geçtiyse yarınki öğleni hedefle
            if (timeInMillis <= now.timeInMillis) {
                add(Calendar.DAY_OF_MONTH, 1)
            }
        }
        return noon.timeInMillis - now.timeInMillis
    }
}
