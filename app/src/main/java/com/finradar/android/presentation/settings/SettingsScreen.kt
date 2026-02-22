package com.finradar.android.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.finradar.android.R
import com.finradar.android.ui.theme.*
import kotlinx.coroutines.launch

data class AppLanguage(val code: String, val nativeName: String, val flag: String)

val supportedLanguages = listOf(
    AppLanguage("tr", "Türkçe",   "🇹🇷"),
    AppLanguage("en", "English",  "🇬🇧"),
    AppLanguage("de", "Deutsch",  "🇩🇪"),
    AppLanguage("fr", "Français", "🇫🇷"),
    AppLanguage("es", "Español",  "🇪🇸"),
    AppLanguage("ar", "العربية",  "🇸🇦"),
    AppLanguage("zh", "中文",     "🇨🇳"),
    AppLanguage("ja", "日本語",   "🇯🇵"),
    AppLanguage("ru", "Русский",  "🇷🇺")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    val isDark    by viewModel.isDarkTheme.collectAsState()
    val langCode  by viewModel.languageCode.collectAsState()
    var showLangSheet by remember { mutableStateOf(false) }
    val context   = LocalContext.current
    val scope     = rememberCoroutineScope()
    val currentLang = supportedLanguages.find { it.code == langCode } ?: supportedLanguages.first()

    if (showLangSheet) {
        ModalBottomSheet(
            onDismissRequest = { showLangSheet = false },
            containerColor   = BgDeep,
            dragHandle = {
                Box(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .size(width = 40.dp, height = 4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(BgStroke)
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 32.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    stringResource(R.string.settings_pick_language),
                    color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                supportedLanguages.forEach { lang ->
                    val selected = lang.code == langCode
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(if (selected) BrandFrom.copy(alpha = 0.10f) else Color.Transparent)
                            .clickable {
                                showLangSheet = false
                                // Launch coroutine: persist synchronously THEN recreate
                                scope.launch {
                                    viewModel.setLanguageAndWait(lang.code)
                                    (context as? android.app.Activity)?.recreate()
                                }
                            }
                            .padding(horizontal = 16.dp, vertical = 14.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(lang.flag, fontSize = 22.sp)
                        Text(
                            lang.nativeName,
                            color = if (selected) BrandFrom else TextHigh,
                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 15.sp,
                            modifier = Modifier.weight(1f)
                        )
                        if (selected) Text("✓", color = BrandFrom, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }
        }
    }

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.settings_title),
                        color = TextHigh, fontWeight = FontWeight.Bold,
                        fontSize = 20.sp, letterSpacing = (-0.5).sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier.height(4.dp))

            SectionHeader(stringResource(R.string.settings_appearance))

            SettingsCard {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        SettingsIconBadge(if (isDark) "🌙" else "☀️")
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(stringResource(R.string.settings_dark_mode), color = TextHigh, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                            Text(stringResource(if (isDark) R.string.settings_dark_mode_on else R.string.settings_dark_mode_off), color = TextMed, fontSize = 12.sp)
                        }
                    }
                    Switch(
                        checked = isDark,
                        onCheckedChange = { viewModel.toggleTheme() },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor   = Color.White,
                            checkedTrackColor   = BrandFrom,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = BgStroke
                        )
                    )
                }
            }

            SectionHeader(stringResource(R.string.settings_language_region))

            SettingsCard(onClick = { showLangSheet = true }) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        SettingsIconBadge(currentLang.flag)
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(stringResource(R.string.settings_app_language), color = TextHigh, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                            Text(currentLang.nativeName, color = TextMed, fontSize = 12.sp)
                        }
                    }
                    Text("›", color = TextMed, fontSize = 22.sp, fontWeight = FontWeight.Light)
                }
            }

            Spacer(Modifier.height(8.dp))
            SectionHeader(stringResource(R.string.settings_app))

            SettingsCard {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    InfoRow(label = stringResource(R.string.settings_app_name_label), value = "FinRadar")
                    HorizontalDivider(color = BgStroke, thickness = 0.5.dp)
                    InfoRow(label = stringResource(R.string.settings_version), value = "1.0.0")
                }
            }

            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Brush.linearGradient(listOf(BrandFrom, BrandMid)))
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("💙", fontSize = 28.sp)
                    Text("FinRadar", color = Color.White, fontWeight = FontWeight.Black, fontSize = 18.sp)
                    Text(stringResource(R.string.settings_tagline), color = Color.White.copy(alpha = 0.75f), fontSize = 12.sp)
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable private fun SectionHeader(title: String) {
    Text(title, color = TextLow, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 1.5.sp)
}

@Composable private fun SettingsIconBadge(emoji: String) {
    Box(
        modifier = Modifier.size(44.dp).clip(RoundedCornerShape(13.dp)).background(BrandFrom.copy(alpha = 0.10f)),
        contentAlignment = Alignment.Center
    ) { Text(emoji, fontSize = 20.sp) }
}

@Composable private fun SettingsCard(onClick: (() -> Unit)? = null, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(BgCard)
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
            .padding(horizontal = 20.dp, vertical = 18.dp),
        content = content
    )
}

@Composable private fun InfoRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = TextMed, fontSize = 14.sp)
        Text(value, color = TextHigh, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
    }
}
