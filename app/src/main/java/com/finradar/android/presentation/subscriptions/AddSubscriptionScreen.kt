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

val subscriptionCategories = listOf(
    "Yayın Hizmeti",
    "Müzik",
    "Yazılım",
    "Bulut Depolama",
    "Oyun",
    "Fitness",
    "Eğitim",
    "Haberler",
    "Genel"
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Abonelik Ekle",
                        color = TextPrimary,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Geri",
                            tint = TextPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Background)
            )
        },
        containerColor = Background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // Header illustration
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(GradientStart, GradientPurple)
                        )
                    )
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("➕", fontSize = 36.sp)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Yeni Abonelik",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        "Manuel olarak abonelik ekleyin",
                        color = Color.White.copy(alpha = 0.75f),
                        fontSize = 13.sp
                    )
                }
            }

            // Name Field
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    "Abonelik Adı",
                    color = TextSecondary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        nameError = false
                    },
                    placeholder = { Text("Netflix, Spotify, vb.", color = TextDisabled) },
                    isError = nameError,
                    supportingText = {
                        if (nameError) Text("Abonelik adı boş bırakılamaz", color = ErrorRed)
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = CardBackground,
                        unfocusedContainerColor = CardBackground,
                        focusedBorderColor = Primary,
                        unfocusedBorderColor = TextDisabled,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary,
                        errorContainerColor = CardBackground,
                        errorBorderColor = ErrorRed
                    )
                )
            }

            // Amount Field
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    "Aylık Tutar (₺)",
                    color = TextSecondary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
                OutlinedTextField(
                    value = amountText,
                    onValueChange = {
                        amountText = it.replace(',', '.')
                        amountError = false
                    },
                    placeholder = { Text("0.00", color = TextDisabled) },
                    isError = amountError,
                    supportingText = {
                        if (amountError) Text("Geçerli bir tutar girin", color = ErrorRed)
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = CardBackground,
                        unfocusedContainerColor = CardBackground,
                        focusedBorderColor = Primary,
                        unfocusedBorderColor = TextDisabled,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary,
                        errorContainerColor = CardBackground,
                        errorBorderColor = ErrorRed
                    )
                )
            }

            // Category Dropdown
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    "Kategori",
                    color = TextSecondary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
                ExposedDropdownMenuBox(
                    expanded = categoryMenuExpanded,
                    onExpandedChange = { categoryMenuExpanded = !categoryMenuExpanded }
                ) {
                    OutlinedTextField(
                        value = selectedCategory,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryMenuExpanded) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = CardBackground,
                            unfocusedContainerColor = CardBackground,
                            focusedBorderColor = Primary,
                            unfocusedBorderColor = TextDisabled,
                            focusedTextColor = TextPrimary,
                            unfocusedTextColor = TextPrimary
                        )
                    )
                    ExposedDropdownMenu(
                        expanded = categoryMenuExpanded,
                        onDismissRequest = { categoryMenuExpanded = false },
                        modifier = Modifier.background(SurfaceVariant)
                    ) {
                        subscriptionCategories.forEach { category ->
                            DropdownMenuItem(
                                text = { Text(category, color = TextPrimary) },
                                onClick = {
                                    selectedCategory = category
                                    categoryMenuExpanded = false
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Save Button
            Button(
                onClick = {
                    val trimmedName = name.trim()
                    val amount = amountText.toDoubleOrNull()

                    nameError = trimmedName.isEmpty()
                    amountError = amount == null || amount <= 0.0

                    if (!nameError && !amountError) {
                        viewModel.addSubscription(
                            name = trimmedName,
                            amount = amount!!,
                            category = selectedCategory
                        )
                        onNavigateBack()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary)
            ) {
                Text(
                    "Aboneliği Kaydet",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
