package com.finradar.android.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val FinRadarColors = lightColorScheme(
    primary              = BrandFrom,
    onPrimary            = Color.White,
    primaryContainer     = BgCard,
    onPrimaryContainer   = TextHigh,
    secondary            = AccentCyan,
    onSecondary          = Color.White,
    secondaryContainer   = BgCardAlt,
    onSecondaryContainer = TextHigh,
    tertiary             = BrandMid,
    background           = BgDeep,
    onBackground         = TextHigh,
    surface              = BgCard,
    onSurface            = TextHigh,
    surfaceVariant       = BgCardAlt,
    onSurfaceVariant     = TextMed,
    error                = AccentRed,
    onError              = Color.White,
    errorContainer       = Color(0xFFFEE2E2),
    onErrorContainer     = AccentRed,
    outline              = BgStroke
)

@Composable
fun FinRadarTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = BgDeep.toArgb()
            window.navigationBarColor = BgDeep.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = true   // dark icons on white bar
                isAppearanceLightNavigationBars = true
            }
        }
    }

    MaterialTheme(
        colorScheme = FinRadarColors,
        typography  = Typography,
        content     = content
    )
}
