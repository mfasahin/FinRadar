package com.finradar.android.presentation.dashboard

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.finradar.android.R
import com.finradar.android.domain.model.Subscription
import com.finradar.android.presentation.common.localizedCategory
import com.finradar.android.ui.theme.*
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onNavigateToAlerts: () -> Unit,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Brush.linearGradient(listOf(BrandFrom, BrandMid))),
                            contentAlignment = Alignment.Center
                        ) { Text("📡", fontSize = 16.sp) }
                        Spacer(Modifier.width(10.dp))
                        Text(
                            "FinRadar",
                            color = TextHigh, fontWeight = FontWeight.Bold,
                            fontSize = 20.sp, letterSpacing = (-0.5).sp
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onNavigateToAlerts) {
                        BadgedBox(badge = {
                            if (state.unreadAlertCount > 0) {
                                Badge(containerColor = AccentRed) {
                                    Text("${state.unreadAlertCount}", color = TextHigh, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }) {
                            Icon(
                                Icons.Outlined.Notifications,
                                contentDescription = stringResource(R.string.nav_alerts),
                                tint = if (state.unreadAlertCount > 0) AccentRed else TextMed,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item { HeroCard(state.totalMonthlySpend, state.totalActiveCount) }

            item {
                Spacer(Modifier.height(32.dp))
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(3.dp).height(18.dp)
                            .clip(CircleShape)
                            .background(Brush.verticalGradient(listOf(BrandFrom, BrandMid)))
                    )
                    Text(
                        stringResource(R.string.dashboard_top_subs),
                        color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 17.sp
                    )
                }
                Spacer(Modifier.height(14.dp))
            }

            if (state.topSubscriptions.isEmpty()) {
                item { EmptyState() }
            } else {
                items(state.topSubscriptions) { sub ->
                    PremiumSubscriptionRow(sub)
                    Spacer(Modifier.height(10.dp))
                }
            }

            // ── Upcoming Payments Section ─────────────────────────────────
            item {
                Spacer(Modifier.height(28.dp))
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(3.dp).height(18.dp)
                            .clip(CircleShape)
                            .background(Brush.verticalGradient(listOf(AccentAmber, AccentRed)))
                    )
                    Text(
                        stringResource(R.string.dashboard_upcoming),
                        color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 17.sp
                    )
                }
                Spacer(Modifier.height(14.dp))
            }

            if (state.upcomingPayments.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                            .clip(RoundedCornerShape(20.dp)).background(BgDeep).padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            stringResource(R.string.dashboard_no_upcoming),
                            color = TextMed, fontSize = 14.sp
                        )
                    }
                }
            } else {
                items(state.upcomingPayments) { sub ->
                    UpcomingPaymentRow(sub)
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
private fun HeroCard(totalSpend: Double, activeCount: Int) {
    val activeLabel = stringResource(R.string.dashboard_active)
    val avgLabel    = stringResource(R.string.dashboard_avg_per_sub)
    val totalLabel  = stringResource(R.string.dashboard_monthly_total)
    val avgAmount   = if (activeCount > 0) totalSpend / activeCount else 0.0

    Box(modifier = Modifier.fillMaxWidth().height(236.dp)) {
        Box(modifier = Modifier.size(260.dp).offset(x = (-40).dp, y = (-20).dp)
            .blur(80.dp).background(BrandFrom.copy(alpha = 0.3f), CircleShape))
        Box(modifier = Modifier.size(200.dp).align(Alignment.BottomEnd)
            .offset(x = 40.dp, y = 40.dp).blur(80.dp)
            .background(BrandMid.copy(alpha = 0.25f), CircleShape))

        Box(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 8.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(Brush.linearGradient(
                    colors = listOf(BrandFrom.copy(alpha = 0.9f), BrandMid.copy(alpha = 0.82f), BrandTo.copy(alpha = 0.75f)),
                    start = Offset(0f, 0f), end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                ))
        ) {
            Box(modifier = Modifier.fillMaxSize().background(
                Brush.radialGradient(listOf(Color.White.copy(alpha = 0.08f), Color.Transparent), radius = 400f)
            ))
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(totalLabel, color = Color.White.copy(alpha = 0.85f), fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold, letterSpacing = 0.8.sp)

                Text(formatAmount(totalSpend), color = Color.White, fontSize = 38.sp,
                    fontWeight = FontWeight.Black, letterSpacing = (-1.5).sp, lineHeight = 42.sp)

                Box(modifier = Modifier.fillMaxWidth().height(1.dp)
                    .background(Color.White.copy(alpha = 0.2f)))

                // Stats row
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White.copy(alpha = 0.14f))
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Active count
                    Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("$activeCount", color = Color.White, fontSize = 20.sp,
                            fontWeight = FontWeight.Black, letterSpacing = (-0.5).sp)
                        Text(activeLabel, color = Color.White.copy(alpha = 0.7f),
                            fontSize = 11.sp, fontWeight = FontWeight.Medium)
                    }
                    Box(modifier = Modifier.width(1.dp).height(32.dp)
                        .background(Color.White.copy(alpha = 0.3f)))
                    // Average per subscription
                    Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(formatAmount(avgAmount), color = Color.White, fontSize = 14.sp,
                            fontWeight = FontWeight.Black, letterSpacing = (-0.3).sp)
                        Text(avgLabel, color = Color.White.copy(alpha = 0.7f),
                            fontSize = 11.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}


@Composable
fun PremiumSubscriptionRow(subscription: Subscription) {
    val genLabel = stringResource(R.string.subs_general)
    val colorIdx = (subscription.name.hashCode() % CategoryColors.size).let { if (it < 0) it + CategoryColors.size else it }
    val accent = CategoryColors[colorIdx]

    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        .clip(RoundedCornerShape(20.dp)).background(BgDeep)) {
        Box(modifier = Modifier.width(3.dp).fillMaxHeight()
            .background(Brush.verticalGradient(listOf(accent, accent.copy(alpha = 0.3f)))))
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 18.dp, end = 16.dp, top = 14.dp, bottom = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(44.dp).clip(RoundedCornerShape(13.dp))
                .background(accent.copy(alpha = 0.15f)), contentAlignment = Alignment.Center) {
                Text(subscription.name.take(1).uppercase(), color = accent, fontWeight = FontWeight.Black, fontSize = 18.sp)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(subscription.name, color = TextHigh, fontWeight = FontWeight.SemiBold, fontSize = 15.sp,
                    maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(localizedCategory(subscription.category), color = TextMed, fontSize = 12.sp)
            }
            Text(formatAmount(subscription.averageAmount), color = accent,
                fontWeight = FontWeight.Black, fontSize = 16.sp, letterSpacing = (-0.5).sp)
        }
    }
}

@Composable
fun EmptyState(message: String? = null) {
    val defaultMsg = stringResource(R.string.dashboard_empty)
    Box(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(20.dp)).background(BgDeep).padding(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text("🔍", fontSize = 32.sp)
            Text(message ?: defaultMsg, color = TextMed, fontSize = 14.sp, lineHeight = 22.sp)
        }
    }
}

@Composable
fun UpcomingPaymentRow(subscription: Subscription) {
    val colorIdx = (subscription.name.hashCode() % CategoryColors.size).let { if (it < 0) it + CategoryColors.size else it }
    val accent   = CategoryColors[colorIdx]
    val today    = System.currentTimeMillis()
    val daysUntil = TimeUnit.MILLISECONDS.toDays(subscription.nextPaymentDate - today)
    val dateStr  = SimpleDateFormat("dd MMM", Locale.getDefault()).format(Date(subscription.nextPaymentDate))
    val amountFmt = NumberFormat.getCurrencyInstance(Locale("tr", "TR"))

    val (badgeColor, badgeText) = when {
        daysUntil <= 0L -> AccentRed    to stringResource(R.string.subs_due_today)
        daysUntil <= 3L -> AccentAmber  to stringResource(R.string.subs_due_days, daysUntil)
        else            -> AccentCyan   to stringResource(R.string.subs_due_days, daysUntil)
    }

    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        .clip(RoundedCornerShape(20.dp)).background(BgDeep)) {
        Box(modifier = Modifier.width(3.dp).fillMaxHeight()
            .background(Brush.verticalGradient(listOf(badgeColor, badgeColor.copy(alpha = 0.3f)))))
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 18.dp, end = 16.dp, top = 14.dp, bottom = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            Box(modifier = Modifier.size(44.dp).clip(RoundedCornerShape(13.dp))
                .background(accent.copy(alpha = 0.15f)), contentAlignment = Alignment.Center) {
                Text(subscription.name.take(1).uppercase(), color = accent, fontWeight = FontWeight.Black, fontSize = 18.sp)
            }
            // Name + date
            Column(modifier = Modifier.weight(1f)) {
                Text(subscription.name, color = TextHigh, fontWeight = FontWeight.SemiBold, fontSize = 15.sp,
                    maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(dateStr, color = TextMed, fontSize = 12.sp)
            }
            // Countdown badge
            Box(
                modifier = Modifier.clip(RoundedCornerShape(12.dp))
                    .background(badgeColor.copy(alpha = 0.15f))
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Text(badgeText, color = badgeColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            // Amount
            Text(
                amountFmt.format(subscription.averageAmount),
                color = accent, fontWeight = FontWeight.Black, fontSize = 15.sp, letterSpacing = (-0.5).sp
            )
        }
    }
}

private fun formatAmount(amount: Double) =
    NumberFormat.getCurrencyInstance(Locale("tr", "TR")).format(amount)
