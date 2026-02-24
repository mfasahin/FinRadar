package com.finradar.android.presentation.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finradar.android.R
import com.finradar.android.ui.theme.*

@Composable
fun OnboardingScreen(
    onPermissionsGranted: () -> Unit,
    onNavigateToPrivacy: () -> Unit
) {
    val scrollState = rememberScrollState()
    
    val featureList = listOf(
        Feature("🔔", stringResource(R.string.onboarding_feature_1_title), stringResource(R.string.onboarding_feature_1_desc)),
        Feature("📈", stringResource(R.string.onboarding_feature_2_title), stringResource(R.string.onboarding_feature_2_desc)),
        Feature("🔒", stringResource(R.string.onboarding_feature_3_title), stringResource(R.string.onboarding_feature_3_desc))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDeep)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(72.dp))

            // Logo
            Box(
                modifier = Modifier
                    .size(88.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Brush.linearGradient(listOf(BrandFrom, BrandMid, BrandTo))),
                contentAlignment = Alignment.Center
            ) {
                Text("📡", fontSize = 38.sp)
            }

            Spacer(Modifier.height(20.dp))

            Text(
                "FinRadar",
                color = TextHigh,
                fontWeight = FontWeight.Black,
                fontSize = 36.sp,
                letterSpacing = (-1.5).sp
            )
            Text(
                "Aboneliklerinizin Radarı",
                color = TextMed,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(Modifier.height(48.dp))

            featureList.forEach { f ->
                FeatureCard(f)
                Spacer(Modifier.height(12.dp))
            }

            Spacer(Modifier.height(32.dp))

            // Privacy disclaimer
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(BgCard)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    stringResource(R.string.onboarding_privacy_disclaimer),
                    color = TextHigh,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                )
                TextButton(
                    onClick = onNavigateToPrivacy,
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        stringResource(R.string.onboarding_view_privacy_policy),
                        color = BrandFrom,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = onPermissionsGranted,
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrandFrom)
            ) {
                Text(
                    stringResource(R.string.onboarding_start_button), 
                    fontWeight = FontWeight.Bold, 
                    fontSize = 16.sp, 
                    color = Color.White
                )
            }

            Spacer(Modifier.height(36.dp))
        }
    }
}

private data class Feature(val emoji: String, val title: String, val desc: String)

@Composable
private fun FeatureCard(feature: Feature) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(BgCard)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(BgCardAlt),
            contentAlignment = Alignment.Center
        ) {
            Text(feature.emoji, fontSize = 22.sp)
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(feature.title, color = TextHigh, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
            Text(feature.desc, color = TextMed, fontSize = 13.sp, lineHeight = 18.sp)
        }
    }
}
