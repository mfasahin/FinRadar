package com.finradar.android.presentation.subscriptions

import android.app.DatePickerDialog
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.finradar.android.R
import com.finradar.android.presentation.common.CategoryMapper
import com.finradar.android.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

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
    val context     = LocalContext.current
    val isEditMode  = subscriptionId != null
    val editTarget  by viewModel.editTarget.collectAsState()

    // Localized labels paired with stable internal keys
    val categoryLabels = CategoryMapper.keys.map { key ->
        key to stringResource(CategoryMapper.resIdFor(key))
    }

    LaunchedEffect(subscriptionId) {
        if (isEditMode) viewModel.loadForEdit(subscriptionId!!)
    }

    var name by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf("") }
    // selectedCategory holds a stable key ("general", "streaming", ...)
    var selectedCategory by remember { mutableStateOf("general") }
    var nextPaymentDate by remember { mutableStateOf(0L) }   // 0 = not set
    var categoryMenuExpanded by remember { mutableStateOf(false) }
    var nameError by remember { mutableStateOf(false) }
    var amountError by remember { mutableStateOf(false) }

    val categoryMap = remember {
        mapOf(
            "netflix" to "streaming", "disney" to "streaming", "prime" to "streaming", "hbo" to "streaming", "youtube" to "streaming",
            "spotify" to "music", "apple music" to "music", "deezer" to "music", "tidal" to "music",
            "steam" to "gaming", "xbox" to "gaming", "playstation" to "gaming", "game pass" to "gaming", "nintendo" to "gaming",
            "adobe" to "software", "office" to "software", "github" to "software", "chatgpt" to "software", "notion" to "software",
            "icloud" to "cloud", "google one" to "cloud", "dropbox" to "cloud",
            "gym" to "fitness", "strava" to "fitness"
        )
    }

    // Pre-fill form in edit mode — normalize legacy Turkish strings to keys
    LaunchedEffect(editTarget) {
        editTarget?.let { sub ->
            name            = sub.name
            amountText      = sub.averageAmount.toString()
            selectedCategory = CategoryMapper.toKey(sub.category)
            nextPaymentDate = sub.nextPaymentDate
        }
    }

    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

    // Shared DatePickerDialog launcher
    fun showDatePicker() {
        val cal = Calendar.getInstance().apply {
            if (nextPaymentDate > 0) timeInMillis = nextPaymentDate
        }
        DatePickerDialog(
            context,
            { _, year, month, day ->
                nextPaymentDate = Calendar.getInstance().apply {
                    set(year, month, day, 0, 0, 0)
                    set(Calendar.MILLISECOND, 0)
                }.timeInMillis
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
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

    val screenTitle     = stringResource(if (isEditMode) R.string.edit_title else R.string.add_title)
    val buttonLabel     = stringResource(if (isEditMode) R.string.add_update else R.string.add_save)
    val nameLbl         = stringResource(R.string.add_name_label)
    val nameHint        = stringResource(R.string.add_name_hint)
    val amountLbl       = stringResource(R.string.add_amount_label)
    val categoryLbl     = stringResource(R.string.add_category_label)
    val nextPayLbl      = stringResource(R.string.add_next_payment_label)
    val nextPayNotSet   = stringResource(R.string.add_next_payment_not_set)

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
            // — Stats card / Edit header ——————————————
            val subs by viewModel.subscriptions.collectAsState()
            val totalCount = subs.size
            val totalSpend = subs.sumOf { it.averageAmount }

            val infiniteTransition = rememberInfiniteTransition(label = "glow")
            val glowAlpha by infiniteTransition.animateFloat(
                initialValue = 0.15f, targetValue = 0.35f,
                animationSpec = infiniteRepeatable(
                    animation = tween(2500, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ), label = "glowAlpha"
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(28.dp))
            ) {
                // Base gradient
                Box(
                    modifier = Modifier.fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                colors = if (isEditMode) listOf(Cat2, BrandFrom, BrandMid)
                                else listOf(BrandFrom, BrandMid, BrandTo),
                                start = Offset(0f, 0f),
                                end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                            )
                        )
                )
                // Animated glow orb
                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = 40.dp, y = (-30).dp)
                        .blur(60.dp)
                        .background(Color.White.copy(alpha = glowAlpha), CircleShape)
                )

                if (isEditMode) {
                    // Edit mode: icon + title
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 28.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(18.dp)
                    ) {
                        Box(
                            modifier = Modifier.size(56.dp).clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.18f)),
                            contentAlignment = Alignment.Center
                        ) { Text("✏️", fontSize = 26.sp) }
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(screenTitle, color = Color.White, fontWeight = FontWeight.Bold,
                                fontSize = 20.sp, letterSpacing = (-0.5).sp)
                            Text(stringResource(R.string.subs_edit),
                                color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
                        }
                    }
                } else {
                    // Add mode: stats overview
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp, vertical = 24.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Active count
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "$totalCount",
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 32.sp,
                                letterSpacing = (-1).sp
                            )
                            Text(
                                stringResource(R.string.stats_active_count),
                                color = Color.White.copy(alpha = 0.75f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        // Divider
                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .height(44.dp)
                                .background(Color.White.copy(alpha = 0.25f))
                        )
                        // Monthly spend
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "₺${String.format("%.0f", totalSpend)}",
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 32.sp,
                                letterSpacing = (-1).sp
                            )
                            Text(
                                stringResource(R.string.stats_monthly_spend),
                                color = Color.White.copy(alpha = 0.75f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }

            // Name
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(nameLbl, color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
                OutlinedTextField(
                    value = name,
                    onValueChange = { newValue ->
                        name = newValue
                        nameError = false
                        // Smart category suggestion
                        val lower = newValue.lowercase()
                        categoryMap.entries.firstOrNull { lower.contains(it.key) }?.let {
                            selectedCategory = it.value
                        }
                    },
                    placeholder = { Text(nameHint, color = TextLow) },
                    leadingIcon = { Icon(Icons.Outlined.Label, null, tint = TextMed, modifier = Modifier.size(20.dp)) },
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
                    leadingIcon = { Icon(Icons.Outlined.Payments, null, tint = TextMed, modifier = Modifier.size(20.dp)) },
                    isError = amountError,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = fieldColors
                )
            }

            // Next payment date picker
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(nextPayLbl, color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(BgCard)
                        .clickable { showDatePicker() }
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            Icons.Outlined.DateRange,
                            contentDescription = null,
                            tint = if (nextPaymentDate > 0) BrandFrom else TextMed,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            if (nextPaymentDate > 0) dateFormat.format(Date(nextPaymentDate)) else nextPayNotSet,
                            color = if (nextPaymentDate > 0) TextHigh else TextMed,
                            fontSize = 15.sp
                        )
                        if (nextPaymentDate > 0) {
                            Spacer(Modifier.weight(1f))
                            Text(
                                "✕",
                                color = TextMed,
                                fontSize = 14.sp,
                                modifier = Modifier.clickable { nextPaymentDate = 0L }
                            )
                        }
                    }
                }
            }

            // Category dropdown
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(categoryLbl, color = TextMed, fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
                val displayLabel = categoryLabels.firstOrNull { it.first == selectedCategory }?.second
                    ?: categoryLabels.last().second
                ExposedDropdownMenuBox(
                    expanded = categoryMenuExpanded,
                    onExpandedChange = { categoryMenuExpanded = !categoryMenuExpanded }
                ) {
                    OutlinedTextField(
                        value = displayLabel,
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
                        categoryLabels.forEach { (key, label) ->
                            DropdownMenuItem(
                                text = { Text(label, color = TextHigh) },
                                onClick = { selectedCategory = key; categoryMenuExpanded = false }
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            // Impact Preview
            val newAmount = amountText.toDoubleOrNull() ?: 0.0
            if (newAmount > 0) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(BrandFrom.copy(alpha = 0.08f))
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Yeni Aylık Toplam: ₺${String.format("%.0f", totalSpend + newAmount)} (+₺${String.format("%.0f", newAmount)})",
                        color = BrandFrom,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
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
                        if (isEditMode) viewModel.updateSubscription(subscriptionId!!, name.trim(), amt!!, selectedCategory, nextPaymentDate)
                        else            viewModel.addSubscription(name.trim(), amt!!, selectedCategory, nextPaymentDate)
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
