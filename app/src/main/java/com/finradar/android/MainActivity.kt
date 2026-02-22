package com.finradar.android

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.finradar.android.presentation.navigation.FinRadarNavGraph
import com.finradar.android.presentation.settings.SettingsViewModel
import com.finradar.android.ui.theme.FinRadarTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
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
        setContent {
            val isDark by settingsViewModel.isDarkTheme.collectAsState()

            FinRadarTheme(isDark = isDark) {
                val navController = rememberNavController()
                FinRadarNavGraph(navController = navController)
            }
        }
    }
}
