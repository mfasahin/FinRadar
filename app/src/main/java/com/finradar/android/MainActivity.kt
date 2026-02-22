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
        // Read language synchronously from SharedPreferences (mirrors DataStore selection)
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

        // Create notification channel & request permission on Android 13+
        NotificationHelper.createChannel(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
        ) {
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {}.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        // Schedule daily payment reminder worker
        val workRequest = PeriodicWorkRequestBuilder<PaymentReminderWorker>(1, TimeUnit.DAYS)
            .setConstraints(Constraints.Builder().setRequiresBatteryNotLow(true).build())
            .build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "payment_reminders",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )

        // ⚠️ TEST ONLY — Remove after testing!
        val testWork = OneTimeWorkRequestBuilder<PaymentReminderWorker>().build()
        WorkManager.getInstance(this).enqueue(testWork)


        setContent {
            val isDark by settingsViewModel.isDarkTheme.collectAsState()

            FinRadarTheme(isDark = isDark) {
                val navController = rememberNavController()
                FinRadarNavGraph(navController = navController)
            }
        }
    }
}
