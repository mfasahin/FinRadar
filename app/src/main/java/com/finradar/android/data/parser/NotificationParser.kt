package com.finradar.android.data.parser

import com.finradar.android.domain.model.Transaction
import java.text.NumberFormat
import java.util.Locale

class NotificationParser {

    // Common digital subscription brands
    private val brands = listOf(
        "NETFLIX", "SPOTIFY", "AMAZON", "PRIME", "APPLE", "GOOGLE", "YOUTUBE", 
        "ADOBE", "MICROSOFT", "XBOX", "PLAYSTATION", "STEAM", "DISNEY", 
        "BLUTV", "EXXEN", "MUBI", "CHATGPT", "OPENAI", "GITHUB", "NOTION", "CANVA"
    )

    fun parseNotification(packageName: String, title: String, text: String, timestamp: Long): Transaction? {
        // We only care about bank or finance notifications
        val textUpper = text.uppercase(Locale.getDefault())

        // 1. Is it a spending or payment notification? 
        // Checking for words closely related to withdrawal / payment / card spending in TR
        if (!textUpper.contains("HARCAMA") && 
            !textUpper.contains("ÖDEME") && 
            !textUpper.contains("ÇEKİLDİ") && 
            !textUpper.contains("IŞLEM") && 
            !textUpper.contains("IŞLEMI") &&
            !textUpper.contains("İŞLEMİ")) {
            return null
        }

        // 2. Find the exact brand from the text
        val matchedBrand = brands.firstOrNull { textUpper.contains(it) } ?: return null

        // 3. Extract amount (e.g. "199,99 TL", "USD 14.99", "50 TL")
        val amount = extractAmount(text) ?: return null

        // Default currency assumption based on text
        val currency = when {
            textUpper.contains("USD") || textUpper.contains("$") -> "USD"
            textUpper.contains("EUR") || textUpper.contains("€") -> "EUR"
            textUpper.contains("GBP") || textUpper.contains("£") -> "GBP"
            else -> "TRY"
        }

        return Transaction(
            date = timestamp,
            amount = amount,
            source = "NOTIFICATION ($packageName)",
            merchantName = matchedBrand, // Real brand capitalized perfectly
            originalMessage = text,
            currency = currency 
        )
    }

    private fun extractAmount(text: String): Double? {
        // Regex to capture numbers with decimals: (e.g., 1.250,99 or 1250.99 or 50)
        // Group 1 will be the number part
        val regex = Regex("""(\d+[.,]?\d*[.,]?\d+)""")
        val match = regex.find(text)
        
        if (match != null) {
            val amountStr = match.groupValues[1]
            return try {
                // If there's multiple dots/commas (like 1.250,50), remove the thousand separator
                // Here is a simplistic approach for Turkish format `1.250,50` -> `1250.50`
                val cleanStr = if (amountStr.contains(",") && amountStr.contains(".")) {
                    amountStr.replace(".", "").replace(",", ".")
                } else if (amountStr.contains(",")) {
                    amountStr.replace(",", ".")
                } else {
                    amountStr // Just dots or whole numbers
                }
                cleanStr.toDouble()
            } catch (e: Exception) {
                null
            }
        }
        return null
    }
}
