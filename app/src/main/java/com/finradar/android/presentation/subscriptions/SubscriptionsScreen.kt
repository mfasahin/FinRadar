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
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Aboneliklerim",
                        color = TextPrimary,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Background)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToAdd,
                containerColor = Primary,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "Abonelik Ekle")
            }
        },
        containerColor = Background
    ) { padding ->
        if (subscriptions.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("📋", fontSize = 48.sp)
                    Text(
                        "Henüz abonelik yok",
                        color = TextPrimary,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "Banka bildirimleri veya + butonu ile\nabonelik ekleyebilirsiniz.",
                        color = TextSecondary,
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(subscriptions) { sub ->
                    SubscriptionDetailCard(sub)
                }
            }
        }
    }
}

@Composable
fun SubscriptionDetailCard(subscription: Subscription) {
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale("tr"))
    val amountFormat = NumberFormat.getCurrencyInstance(Locale("tr", "TR"))

    val gradients = listOf(
        listOf(Color(0xFF4F8EFF), Color(0xFF9747FF)),
        listOf(Color(0xFF00D4FF), Color(0xFF4F8EFF)),
        listOf(Color(0xFF9747FF), Color(0xFFFF4D6D)),
        listOf(Color(0xFF00E5A0), Color(0xFF00D4FF)),
        listOf(Color(0xFFFFB020), Color(0xFFFF4D6D))
    )
    val idx = (subscription.name.hashCode() % gradients.size).let { if (it < 0) it + gradients.size else it }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Gradient avatar
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Brush.linearGradient(gradients[idx])),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = subscription.name.take(1).uppercase(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = subscription.name,
                    color = TextPrimary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = subscription.category ?: "Genel",
                    color = TextSecondary,
                    fontSize = 12.sp
                )
                Text(
                    text = "Son ödeme: ${dateFormat.format(Date(subscription.lastPaymentDate))}",
                    color = TextDisabled,
                    fontSize = 11.sp
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = amountFormat.format(subscription.averageAmount),
                    color = Primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "/ ay",
                    color = TextSecondary,
                    fontSize = 11.sp
                )
            }
        }
    }
}
