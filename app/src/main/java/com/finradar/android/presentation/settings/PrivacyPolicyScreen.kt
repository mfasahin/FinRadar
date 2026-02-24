package com.finradar.android.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finradar.android.R
import com.finradar.android.ui.theme.*
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(
    onNavigateBack: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val langCode by viewModel.languageCode.collectAsState()
    val title = PrivacyPolicyContent.getTitle(langCode)
    val lastUpdated = PrivacyPolicyContent.getLastUpdated(langCode)
    val sections = PrivacyPolicyContent.getSections(langCode)
    
    val backLabel = when(langCode) {
        "tr" -> "Geri"
        "de" -> "Zurück"
        "fr" -> "Retour"
        else -> "Back"
    }

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                title = { Text(title, color = TextHigh, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = backLabel, tint = TextHigh)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BgDeep)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                lastUpdated,
                color = TextLow,
                fontSize = 12.sp
            )

            sections.forEach { (secTitle, secContent) ->
                PrivacySection(title = secTitle, content = secContent)
            }
            
            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun PrivacySection(title: String, content: String) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(title, color = BrandFrom, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(content, color = TextMed, fontSize = 14.sp, lineHeight = 22.sp)
    }
}
