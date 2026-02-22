package com.finradar.android.ui.theme

import androidx.compose.ui.graphics.Color

// ── Brand gradient (same in both themes) ──────────────────────────────────
val BrandFrom     = Color(0xFF1D4ED8)   // Deep royal blue
val BrandMid      = Color(0xFF3B82F6)   // Medium blue
val BrandTo       = Color(0xFF93C5FD)   // Sky blue

// ── Accent (same in both themes) ──────────────────────────────────────────
val AccentCyan    = Color(0xFF0284C7)
val AccentGreen   = Color(0xFF059669)
val AccentAmber   = Color(0xFFD97706)
val AccentRed     = Color(0xFFDC2626)

// ── LIGHT theme tokens ─────────────────────────────────────────────────────
val LightBgDeep   = Color(0xFFFFFFFF)   // Pure white
val LightBgCard   = Color(0xFFF0F5FF)   // Light blue-tint cards
val LightBgCardAlt= Color(0xFFE4EDFF)
val LightBgStroke = Color(0xFFBFD4FF)
val LightTextHigh = Color(0xFF0F172A)   // Near-black navy
val LightTextMed  = Color(0xFF475569)   // Slate gray
val LightTextLow  = Color(0xFF94A3B8)   // Light slate

// ── DARK theme tokens ──────────────────────────────────────────────────────
val DarkBgDeep    = Color(0xFF080C18)   // True-black base
val DarkBgCard    = Color(0xFF0E1428)   // Elevated dark card
val DarkBgCardAlt = Color(0xFF141D35)
val DarkBgStroke  = Color(0xFF1E2D55)
val DarkTextHigh  = Color(0xFFF1F5F9)   // Near-white
val DarkTextMed   = Color(0xFF94A3B8)   // Muted slate
val DarkTextLow   = Color(0xFF475569)   // Dimmer slate

// ── Current-theme aliases (set by LocalAppTheme composition local) ─────────
// These are declared as vars in the theme-aware objects, accessed via AppColors
// We keep LIGHT as the file-level defaults so existing code compiles without changes
var BgDeep     = LightBgDeep
var BgCard     = LightBgCard
var BgCardAlt  = LightBgCardAlt
var BgStroke   = LightBgStroke
var TextHigh   = LightTextHigh
var TextMed    = LightTextMed
var TextLow    = LightTextLow

// ── Category palette ───────────────────────────────────────────────────────
val Cat1 = Color(0xFF1D4ED8)
val Cat2 = Color(0xFF7C3AED)
val Cat3 = Color(0xFF0891B2)
val Cat4 = Color(0xFF059669)
val Cat5 = Color(0xFFD97706)
val Cat6 = Color(0xFFDC2626)
val Cat7 = Color(0xFFDB2777)
val Cat8 = Color(0xFF4F46E5)

val CategoryColors = listOf(Cat1, Cat2, Cat3, Cat4, Cat5, Cat6, Cat7, Cat8)
