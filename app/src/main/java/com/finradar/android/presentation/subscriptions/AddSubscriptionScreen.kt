package com.finradar.android.presentation.subscriptions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.finradar.android.ui.theme.*

private val subscriptionCategories = listOf(
    "Yayın Hizmeti", "Müzik", "Yazılım", "Bulut Depolama",
    "Oyun", "Fitness", "Eğitim", "Haberler", "Genel"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSubscriptionScreen(
    onNavigateBack: () -> Unit,
    viewModel: SubscriptionsViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Genel") }
    var categoryMenuExpanded by remember { mutableStateOf(false) }
    var nameError by remember { mutableStateOf(false) }
    var amountError by remember { mutableStateOf(false) }

    val fieldColors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor   = BgCard,
        unfocusedContainerColor = BgCard,
        focusedBorderColor      = BrandFrom,
        unfocusedBorderColor    = BgStroke,
        focusedTextColor        = TextHigh,
        unfocusedTextColor      = TextHigh,
        errorContainerColor     = BgCard,
        errorBorderColor        = AccentRed,
        focusedLabelColor       = BrandFrom,
        unfocusedLabelColor     = TextMed
    )

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                title = {
                    Text("Abonelik Ekle", color = TextHigh, fontWeight = FontWeight.Bold,
                        fontSize = 20.sp, letterSpacing = (-0.5).sp)
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Geri", tint = TextHigh)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Header card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        Brush.linearGradient(listOf(BrandFrom, BrandMid, BrandTo))
                    )
                    .padding(28.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text("➕", fontSize = 36.sp)
                    Text("Yeni Abonelik Ekle", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("Bilgileri doldurun ve kaydedin", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
                }
            }

            // Name field
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Abonelik Adı", color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it; nameError = false },
                    placeholder = { Text("Netflix, Spotify, vb.", color = TextLow) },
                    isError = nameError,
                    supportingText = { if (nameError) Text("Bu alan zorunludur", color = AccentRed, fontSize = 12.sp) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = fieldColors
                )
            }

            // Amount field
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Aylık Tutar (₺)", color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
                OutlinedTextField(
                    value = amountText,
                    onValueChange = { amountText = it.replace(',', '.'); amountError = false },
                    placeholder = { Text("0.00", color = TextLow) },
                    isError = amountError,
                    supportingText = { if (amountError) Text("Geçerli bir tutar girin", color = AccentRed, fontSize = 12.sp) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = fieldColors
                )
            }

            // Category dropdown
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Kategori", color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
                ExposedDropdownMenuBox(
                    expanded = categoryMenuExpanded,
                    onExpandedChange = { categoryMenuExpanded = !categoryMenuExpanded }
                ) {
                    OutlinedTextField(
                        value = selectedCategory,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryMenuExpanded) },
                        modifier = Modifier.fillMaxWidth().menuAnchor(),
                        shape = RoundedCornerShape(14.dp),
                        colors = fieldColors
                    )
                    ExposedDropdownMenu(
                        expanded = categoryMenuExpanded,
                        onDismissRequest = { categoryMenuExpanded = false },
                        modifier = Modifier.background(BgCardAlt)
                    ) {
                        subscriptionCategories.forEach { category ->
                            DropdownMenuItem(
                                text = { Text(category, color = TextHigh) },
                                onClick = { selectedCategory = category; categoryMenuExpanded = false }
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            // Save button
            Button(
                onClick = {
                    val amt = amountText.toDoubleOrNull()
                    nameError = name.trim().isEmpty()
                    amountError = amt == null || amt <= 0.0
                    if (!nameError && !amountError) {
                        viewModel.addSubscription(name.trim(), amt!!, selectedCategory)
                        onNavigateBack()
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrandFrom)
            ) {
                Text("Kaydet", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
            }

            Spacer(Modifier.height(20.dp))
        }
    }
}
