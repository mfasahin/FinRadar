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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.finradar.android.R
import com.finradar.android.ui.theme.*

/**
 * Add (subscriptionId=null) and Edit (subscriptionId!=null) in one screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSubscriptionScreen(
    subscriptionId: Long?,
    onNavigateBack: () -> Unit,
    viewModel: SubscriptionsViewModel = hiltViewModel()
) {
    val isEditMode = subscriptionId != null
    val editTarget by viewModel.editTarget.collectAsState()

    // Category labels — declared here so stringResource is available
    val categories = listOf(
        stringResource(R.string.cat_streaming),
        stringResource(R.string.cat_music),
        stringResource(R.string.cat_software),
        stringResource(R.string.cat_cloud),
        stringResource(R.string.cat_gaming),
        stringResource(R.string.cat_fitness),
        stringResource(R.string.cat_education),
        stringResource(R.string.cat_news),
        stringResource(R.string.cat_general)
    )

    LaunchedEffect(subscriptionId) {
        if (isEditMode) viewModel.loadForEdit(subscriptionId!!)
    }

    var name by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("") }
    var categoryMenuExpanded by remember { mutableStateOf(false) }
    var nameError by remember { mutableStateOf(false) }
    var amountError by remember { mutableStateOf(false) }

    // Set default category once categories are available
    LaunchedEffect(categories) {
        if (selectedCategory.isEmpty() && !isEditMode) {
            selectedCategory = categories.last()  // "Genel" / "General" / etc.
        }
    }

    // Pre-fill form in edit mode
    LaunchedEffect(editTarget) {
        editTarget?.let { sub ->
            name = sub.name
            amountText = sub.averageAmount.toString()
            selectedCategory = sub.category ?: categories.last()
        }
    }

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

    val screenTitle  = stringResource(if (isEditMode) R.string.edit_title else R.string.add_title)
    val buttonLabel  = stringResource(if (isEditMode) R.string.add_update else R.string.add_save)
    val nameLbl      = stringResource(R.string.add_name_label)
    val nameHint     = stringResource(R.string.add_name_hint)
    val amountLbl    = stringResource(R.string.add_amount_label)
    val categoryLbl  = stringResource(R.string.add_category_label)

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                title = { Text(screenTitle, color = TextHigh, fontWeight = FontWeight.Bold, fontSize = 20.sp, letterSpacing = (-0.5).sp) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = TextHigh)
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
            // Header banner
            Box(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Brush.linearGradient(listOf(BrandFrom, BrandMid, BrandTo)))
                    .padding(28.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(if (isEditMode) "✏️" else "➕", fontSize = 36.sp)
                    Text(screenTitle, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }

            // Name
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(nameLbl, color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it; nameError = false },
                    placeholder = { Text(nameHint, color = TextLow) },
                    isError = nameError,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = fieldColors
                )
            }

            // Amount
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(amountLbl, color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
                OutlinedTextField(
                    value = amountText,
                    onValueChange = { amountText = it.replace(',', '.'); amountError = false },
                    placeholder = { Text("0.00", color = TextLow) },
                    isError = amountError,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = fieldColors
                )
            }

            // Category dropdown
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(categoryLbl, color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
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
                        modifier = Modifier.background(BgCard)
                    ) {
                        categories.forEach { cat ->
                            DropdownMenuItem(
                                text = { Text(cat, color = TextHigh) },
                                onClick = { selectedCategory = cat; categoryMenuExpanded = false }
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            // Save / Update button
            Button(
                onClick = {
                    val amt = amountText.toDoubleOrNull()
                    nameError   = name.trim().isEmpty()
                    amountError = amt == null || amt <= 0.0
                    if (!nameError && !amountError) {
                        if (isEditMode) viewModel.updateSubscription(subscriptionId!!, name.trim(), amt!!, selectedCategory)
                        else            viewModel.addSubscription(name.trim(), amt!!, selectedCategory)
                        onNavigateBack()
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape    = RoundedCornerShape(16.dp),
                colors   = ButtonDefaults.buttonColors(containerColor = BrandFrom)
            ) {
                Text(buttonLabel, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
            }

            Spacer(Modifier.height(20.dp))
        }
    }
}
