package com.finradar.android

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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val settingsViewModel: SettingsViewModel by viewModels()

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
