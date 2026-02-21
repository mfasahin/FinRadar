package com.finradar.android.presentation.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finradar.android.ui.theme.*

data class OnboardingFeature(
    val emoji: String,
    val title: String,
    val description: String
)

private val features = listOf(
    OnboardingFeature("🔔", "Otomatik Tespit", "Banka bildirimlerini okuyarak aboneliklerinizi otomatik tarar."),
    OnboardingFeature("📈", "Zam Uyarıları", "Aboneliğinize zam geldiğinde anında bildirim alın."),
    OnboardingFeature("🔒", "Tamamen Gizli", "Hiçbir veri sunucuya gönderilmez. Her şey cihazınızda.")
)

@Composable
fun OnboardingScreen(onPermissionsGranted: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(60.dp))

            // Logo / Brand area
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(GradientStart, GradientEnd)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("📡", fontSize = 40.sp)
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = "FinRadar",
                color = TextPrimary,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 34.sp
            )

            Text(
                text = "Aboneliklerinizin Radarı",
                color = TextSecondary,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(Modifier.height(48.dp))

            // Feature cards
            features.forEach { feature ->
                FeatureRow(feature)
                Spacer(Modifier.height(16.dp))
            }

            Spacer(Modifier.weight(1f))

            // Privacy note
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(SurfaceVariant)
                    .padding(16.dp)
            ) {
                Text(
                    text = "🔐  Uygulamayı kullanmak için bildirim erişimi gereklidir. Verileriniz asla paylaşılmaz.",
                    color = TextSecondary,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = onPermissionsGranted,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary)
            ) {
                Text(
                    "Bildirim İzni Ver & Başla",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun FeatureRow(feature: OnboardingFeature) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CardBackground)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(SurfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Text(feature.emoji, fontSize = 22.sp)
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                feature.title,
                color = TextPrimary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
            Text(
                feature.description,
                color = TextSecondary,
                fontSize = 13.sp,
                lineHeight = 18.sp
            )
        }
    }
}
