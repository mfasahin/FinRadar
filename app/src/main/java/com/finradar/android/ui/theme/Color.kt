package com.finradar.android.ui.theme

import androidx.compose.ui.graphics.Color

// ── Backgrounds (white / light blue) ──────────────────────────────────────
val BgDeep        = Color(0xFFFFFFFF)   // Pure white screen background
val BgCard        = Color(0xFFF0F5FF)   // Light blue-tint cards
val BgCardAlt     = Color(0xFFE4EDFF)   // Slightly deeper for dropdown/alt
val BgStroke      = Color(0xFFBFD4FF)   // Blue border / divider

// ── Brand gradient (Deep Blue → Mid Blue → Sky) ───────────────────────────
val BrandFrom     = Color(0xFF1D4ED8)   // Deep royal blue
val BrandMid      = Color(0xFF3B82F6)   // Medium blue
val BrandTo       = Color(0xFF93C5FD)   // Sky blue

// ── Accent ─────────────────────────────────────────────────────────────────
val AccentCyan    = Color(0xFF0284C7)   // Strong cyan-blue
val AccentGreen   = Color(0xFF059669)
val AccentAmber   = Color(0xFFD97706)
val AccentRed     = Color(0xFFDC2626)

// ── Text (dark navy on white for max contrast) ────────────────────────────
val TextHigh      = Color(0xFF0F172A)   // Near-black navy
val TextMed       = Color(0xFF475569)   // Slate gray
val TextLow       = Color(0xFF94A3B8)   // Light slate

// ── Category palette (vibrant, readable on light bg) ─────────────────────
val Cat1 = Color(0xFF1D4ED8)
val Cat2 = Color(0xFF7C3AED)
val Cat3 = Color(0xFF0891B2)
val Cat4 = Color(0xFF059669)
val Cat5 = Color(0xFFD97706)
val Cat6 = Color(0xFFDC2626)
val Cat7 = Color(0xFFDB2777)
val Cat8 = Color(0xFF4F46E5)

val CategoryColors = listOf(Cat1, Cat2, Cat3, Cat4, Cat5, Cat6, Cat7, Cat8)
