package com.finradar.android.presentation.alerts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.finradar.android.R
import com.finradar.android.domain.model.Alert
import com.finradar.android.domain.model.AlertType
import com.finradar.android.ui.theme.*
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertsScreen(viewModel: AlertsViewModel = hiltViewModel()) {
    val alerts by viewModel.alerts.collectAsState(initial = emptyList())

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.alerts_title),
                        color = TextHigh, fontWeight = FontWeight.Bold,
                        fontSize = 20.sp, letterSpacing = (-0.5).sp
                    )
                },
                actions = {
                    if (alerts.isNotEmpty()) {
                        TextButton(onClick = { viewModel.clearAllAlerts() }) {
                            Text(
                                stringResource(R.string.alerts_clear_all),
                                color = AccentRed,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { padding ->
        if (alerts.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("🎉", fontSize = 48.sp)
                    Text(stringResource(R.string.alerts_empty_title), color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(stringResource(R.string.alerts_empty_body), color = TextMed, fontSize = 14.sp, lineHeight = 22.sp)
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(alerts, key = { it.id }) { alert ->
                    // Wrapping in a Box to allow swipe-like or simple long-press delete if needed, 
                    // for now let's add a small delete button to the card for simplicity and better UX than just swipe
                    AlertItemWrapper(
                        alert = alert,
                        onDelete = { viewModel.deleteAlert(alert.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun AlertItemWrapper(alert: Alert, onDelete: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        if (alert.type == AlertType.PAYMENT_REMINDER) {
            ReminderAlertCard(alert, onDelete)
        } else {
            PriceChangeAlertCard(alert, onDelete)
        }
    }
}

@Composable
fun PriceChangeAlertCard(alert: Alert, onDelete: () -> Unit) {
    val locale       = Locale.getDefault()
    val dateFormat   = SimpleDateFormat("dd MMM yyyy", locale)
    val amountFormat = NumberFormat.getCurrencyInstance(Locale("tr", "TR"))

    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(BgDeep),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.width(4.dp).height(80.dp)
            .background(Brush.verticalGradient(listOf(AccentRed, AccentRed.copy(alpha = 0.4f))),
                shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)))
        Spacer(Modifier.width(14.dp))
        Box(modifier = Modifier.size(44.dp).clip(RoundedCornerShape(13.dp)).background(AccentRed.copy(alpha = 0.10f)),
            contentAlignment = Alignment.Center) {
            Icon(Icons.Outlined.Warning, contentDescription = null, tint = AccentRed, modifier = Modifier.size(20.dp))
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f).padding(vertical = 16.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(alert.subscriptionName.ifBlank { "Subscription #${alert.subscriptionId}" },
                color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text("${amountFormat.format(alert.oldAmount)}  →  ${amountFormat.format(alert.newAmount)}",
                color = TextMed, fontSize = 13.sp)
            Text(dateFormat.format(Date(alert.date)), color = TextLow, fontSize = 11.sp)
        }
        
        IconButton(onClick = onDelete, modifier = Modifier.padding(end = 4.dp)) {
            Icon(Icons.Default.Delete, contentDescription = stringResource(R.string.alerts_delete), tint = TextLow.copy(alpha = 0.5f), modifier = Modifier.size(20.dp))
        }

        Box(modifier = Modifier.padding(end = 16.dp).clip(RoundedCornerShape(10.dp))
            .background(AccentRed.copy(alpha = 0.10f)).padding(horizontal = 10.dp, vertical = 6.dp)) {
            Text("+%.0f%%".format(alert.percentageChange), color = AccentRed, fontWeight = FontWeight.Black, fontSize = 14.sp)
        }
    }
}

@Composable
fun ReminderAlertCard(alert: Alert, onDelete: () -> Unit) {
    val locale       = Locale.getDefault()
    val dateFormat   = SimpleDateFormat("dd MMM yyyy", locale)
    val amountFormat = NumberFormat.getCurrencyInstance(Locale("tr", "TR"))
    val accentBlue   = BrandFrom

    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(BgDeep),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.width(4.dp).height(80.dp)
            .background(Brush.verticalGradient(listOf(accentBlue, accentBlue.copy(alpha = 0.4f))),
                shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)))
        Spacer(Modifier.width(14.dp))
        Box(modifier = Modifier.size(44.dp).clip(RoundedCornerShape(13.dp)).background(accentBlue.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center) {
            Icon(Icons.Outlined.Notifications, contentDescription = null, tint = accentBlue, modifier = Modifier.size(20.dp))
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f).padding(vertical = 16.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(alert.subscriptionName.ifBlank { "Subscription #${alert.subscriptionId}" },
                color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(amountFormat.format(alert.oldAmount), color = TextMed, fontSize = 13.sp)
            Text(dateFormat.format(Date(alert.date)), color = TextLow, fontSize = 11.sp)
        }

        IconButton(onClick = onDelete, modifier = Modifier.padding(end = 4.dp)) {
            Icon(Icons.Default.Delete, contentDescription = stringResource(R.string.alerts_delete), tint = TextLow.copy(alpha = 0.5f), modifier = Modifier.size(20.dp))
        }

        Box(modifier = Modifier.padding(end = 16.dp).clip(RoundedCornerShape(10.dp))
            .background(accentBlue.copy(alpha = 0.12f)).padding(horizontal = 10.dp, vertical = 6.dp)) {
            Text("🔔", fontSize = 16.sp)
        }
    }
}
