package com.finradar.android.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary              = BrandFrom,
    onPrimary            = Color.White,
    primaryContainer     = LightBgCard,
    onPrimaryContainer   = LightTextHigh,
    secondary            = AccentCyan,
    onSecondary          = Color.White,
    secondaryContainer   = LightBgCardAlt,
    onSecondaryContainer = LightTextHigh,
    tertiary             = BrandMid,
    background           = LightBgDeep,
    onBackground         = LightTextHigh,
    surface              = LightBgCard,
    onSurface            = LightTextHigh,
    surfaceVariant       = LightBgCardAlt,
    onSurfaceVariant     = LightTextMed,
    error                = AccentRed,
    onError              = Color.White,
    errorContainer       = Color(0xFFFEE2E2),
    onErrorContainer     = AccentRed,
    outline              = LightBgStroke
)

private val DarkColors = darkColorScheme(
    primary              = BrandFrom,
    onPrimary            = Color.White,
    primaryContainer     = DarkBgCard,
    onPrimaryContainer   = DarkTextHigh,
    secondary            = AccentCyan,
    onSecondary          = Color.White,
    secondaryContainer   = DarkBgCardAlt,
    onSecondaryContainer = DarkTextHigh,
    tertiary             = BrandMid,
    background           = DarkBgDeep,
    onBackground         = DarkTextHigh,
    surface              = DarkBgCard,
    onSurface            = DarkTextHigh,
    surfaceVariant       = DarkBgCardAlt,
    onSurfaceVariant     = DarkTextMed,
    error                = AccentRed,
    onError              = Color.White,
    errorContainer       = Color(0xFF4B0000),
    onErrorContainer     = Color(0xFFFFB4AB),
    outline              = DarkBgStroke
)

@Composable
fun FinRadarTheme(
    isDark: Boolean = false,
    content: @Composable () -> Unit
) {
    // Update the global alias vars so existing composables pick up correct colors
    BgDeep    = if (isDark) DarkBgDeep    else LightBgDeep
    BgCard    = if (isDark) DarkBgCard    else LightBgCard
    BgCardAlt = if (isDark) DarkBgCardAlt else LightBgCardAlt
    BgStroke  = if (isDark) DarkBgStroke  else LightBgStroke
    TextHigh  = if (isDark) DarkTextHigh  else LightTextHigh
    TextMed   = if (isDark) DarkTextMed   else LightTextMed
    TextLow   = if (isDark) DarkTextLow   else LightTextLow

    val colorScheme = if (isDark) DarkColors else LightColors
    val isLight = !isDark

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val bgColor = if (isDark) DarkBgDeep else LightBgDeep
            window.statusBarColor = bgColor.toArgb()
            window.navigationBarColor = bgColor.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars     = isLight
                isAppearanceLightNavigationBars = isLight
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = Typography,
        content     = content
    )
}
