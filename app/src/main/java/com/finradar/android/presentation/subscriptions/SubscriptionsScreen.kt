package com.finradar.android.presentation.subscriptions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.finradar.android.domain.model.Subscription
import com.finradar.android.ui.theme.*
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionsScreen(
    onNavigateToAdd: () -> Unit,
    viewModel: SubscriptionsViewModel = hiltViewModel()
) {
    val subscriptions by viewModel.subscriptions.collectAsState(initial = emptyList())

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Abonelikler",
                        color = TextHigh,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        letterSpacing = (-0.5).sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToAdd,
                containerColor = BrandFrom,
                contentColor = TextHigh,
                shape = CircleShape,
                modifier = Modifier.size(58.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Abonelik Ekle", modifier = Modifier.size(24.dp))
            }
        }
    ) { padding ->
        if (subscriptions.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("📋", fontSize = 48.sp)
                    Text("Abonelik Yok", color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(
                        "SMS bildirimleri veya + butonu ile\nmanuel olarak ekleyebilirsiniz.",
                        color = TextMed, fontSize = 14.sp, lineHeight = 22.sp
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(subscriptions) { sub -> SubscriptionDetailCard(sub) }
            }
        }
    }
}

@Composable
fun SubscriptionDetailCard(subscription: Subscription) {
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale("tr"))
    val amountFormat = NumberFormat.getCurrencyInstance(Locale("tr", "TR"))
    val colorIdx = (subscription.name.hashCode() % CategoryColors.size)
        .let { if (it < 0) it + CategoryColors.size else it }
    val accent = CategoryColors[colorIdx]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(BgDeep)        // white card
            .then(
                Modifier.padding(0.dp) // no extra padding here
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // ── Left accent bar ────────────────────────────────────────────────
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(76.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(accent, accent.copy(alpha = 0.4f))
                    ),
                    shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)
                )
        )

        Spacer(Modifier.width(14.dp))

        // ── Avatar ─────────────────────────────────────────────────────────
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(accent.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                subscription.name.take(1).uppercase(),
                color = accent,
                fontWeight = FontWeight.Black,
                fontSize = 18.sp
            )
        }

        Spacer(Modifier.width(12.dp))

        // ── Name + category + date ─────────────────────────────────────────
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                subscription.name,
                color = TextHigh,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                subscription.category ?: "Genel",
                color = TextMed,
                fontSize = 12.sp
            )
            Text(
                "Son: ${dateFormat.format(Date(subscription.lastPaymentDate))}",
                color = TextLow,
                fontSize = 11.sp
            )
        }

        // ── Amount ─────────────────────────────────────────────────────────
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Text(
                amountFormat.format(subscription.averageAmount),
                color = accent,
                fontWeight = FontWeight.Black,
                fontSize = 16.sp,
                letterSpacing = (-0.5).sp
            )
            Text("/ ay", color = TextMed, fontSize = 11.sp)
        }
    }
}

