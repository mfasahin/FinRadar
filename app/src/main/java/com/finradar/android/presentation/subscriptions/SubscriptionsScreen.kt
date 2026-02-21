package com.finradar.android.presentation.subscriptions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
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
    onNavigateToEdit: (Long) -> Unit,
    viewModel: SubscriptionsViewModel = hiltViewModel()
) {
    val subscriptions by viewModel.subscriptions.collectAsState(initial = emptyList())
    var deleteCandidate by remember { mutableStateOf<Subscription?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    // Live filtered list
    val filtered = remember(subscriptions, searchQuery) {
        if (searchQuery.isBlank()) subscriptions
        else subscriptions.filter {
            it.name.contains(searchQuery, ignoreCase = true) ||
            it.category.orEmpty().contains(searchQuery, ignoreCase = true)
        }
    }

    // Delete confirmation dialog
    deleteCandidate?.let { sub ->
        AlertDialog(
            onDismissRequest = { deleteCandidate = null },
            containerColor = Color.White,
            title = { Text("Aboneliği Sil", color = TextHigh, fontWeight = FontWeight.Bold) },
            text = { Text("\"${sub.name}\" aboneliğini silmek istediğinize emin misiniz?", color = TextMed) },
            confirmButton = {
                TextButton(onClick = { viewModel.deleteSubscription(sub.id); deleteCandidate = null }) {
                    Text("Sil", color = AccentRed, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { deleteCandidate = null }) { Text("İptal", color = TextMed) }
            }
        )
    }

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            Column(modifier = Modifier.background(BgDeep)) {
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

                // ── Search bar ─────────────────────────────────────────────
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Abonelik ara...", color = TextLow, fontSize = 14.sp) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 12.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor   = BgCard,
                        unfocusedContainerColor = BgCard,
                        focusedBorderColor      = BrandFrom,
                        unfocusedBorderColor    = BgStroke,
                        focusedTextColor        = TextHigh,
                        unfocusedTextColor      = TextHigh
                    ),
                    leadingIcon = {
                        Text("🔍", fontSize = 16.sp, modifier = Modifier.padding(start = 4.dp))
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Text("✕", color = TextMed, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToAdd,
                containerColor = BrandFrom,
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier.size(58.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Abonelik Ekle", modifier = Modifier.size(24.dp))
            }
        }
    ) { padding ->
        when {
            subscriptions.isEmpty() -> EmptyListState(padding)
            filtered.isEmpty() -> NoResultsState(padding, searchQuery)
            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(filtered, key = { it.id }) { sub ->
                        SubscriptionDetailCard(
                            subscription = sub,
                            onEdit   = { onNavigateToEdit(sub.id) },
                            onDelete = { deleteCandidate = sub }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptyListState(padding: PaddingValues) {
    Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("📋", fontSize = 48.sp)
            Text("Abonelik Yok", color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(
                "SMS bildirimleri veya + butonu ile\nmanuel olarak ekleyebilirsiniz.",
                color = TextMed, fontSize = 14.sp, lineHeight = 22.sp
            )
        }
    }
}

@Composable
private fun NoResultsState(padding: PaddingValues, query: String) {
    Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text("🔍", fontSize = 40.sp)
            Text("Sonuç bulunamadı", color = TextHigh, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            Text("\"$query\" ile eşleşen abonelik yok.", color = TextMed, fontSize = 13.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionDetailCard(
    subscription: Subscription,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale("tr"))
    val amountFormat = NumberFormat.getCurrencyInstance(Locale("tr", "TR"))
    val colorIdx = (subscription.name.hashCode() % CategoryColors.size)
        .let { if (it < 0) it + CategoryColors.size else it }
    val accent = CategoryColors[colorIdx]
    var menuExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(BgDeep),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left accent bar
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(76.dp)
                .background(
                    Brush.verticalGradient(listOf(accent, accent.copy(alpha = 0.4f))),
                    shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)
                )
        )

        Spacer(Modifier.width(14.dp))

        // Avatar
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(accent.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center
        ) {
            Text(subscription.name.take(1).uppercase(), color = accent, fontWeight = FontWeight.Black, fontSize = 18.sp)
        }

        Spacer(Modifier.width(12.dp))

        // Name + category + date
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(subscription.name, color = TextHigh, fontWeight = FontWeight.SemiBold, fontSize = 15.sp,
                maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(subscription.category ?: "Genel", color = TextMed, fontSize = 12.sp)
            Text("Son: ${dateFormat.format(Date(subscription.lastPaymentDate))}", color = TextLow, fontSize = 11.sp)
        }

        // Amount
        Column(horizontalAlignment = Alignment.End) {
            Text(amountFormat.format(subscription.averageAmount), color = accent,
                fontWeight = FontWeight.Black, fontSize = 16.sp, letterSpacing = (-0.5).sp)
            Text("/ ay", color = TextMed, fontSize = 11.sp)
        }

        // Kebab menu
        Box {
            IconButton(onClick = { menuExpanded = true }) {
                Text("⋮", color = TextMed, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false },
                modifier = Modifier.background(Color.White)
            ) {
                DropdownMenuItem(
                    text = { Text("Düzenle", color = BrandFrom, fontWeight = FontWeight.SemiBold) },
                    leadingIcon = { Icon(Icons.Outlined.Edit, null, tint = BrandFrom) },
                    onClick = { menuExpanded = false; onEdit() }
                )
                DropdownMenuItem(
                    text = { Text("Sil", color = AccentRed, fontWeight = FontWeight.SemiBold) },
                    leadingIcon = { Icon(Icons.Outlined.Delete, null, tint = AccentRed) },
                    onClick = { menuExpanded = false; onDelete() }
                )
            }
        }
    }
}
