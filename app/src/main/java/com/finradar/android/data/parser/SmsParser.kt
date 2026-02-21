package com.finradar.android.data.parser

import com.finradar.android.domain.model.Transaction
import java.text.NumberFormat
import java.util.Locale

class SmsParser {

    fun parseSms(sender: String, message: String, timestamp: Long): Transaction? {
        // Iterate through all registered patterns
        for ((bankName, pattern) in SmsPatternRegistry.patterns) {
            val matchResult = pattern.find(message)
            if (matchResult != null) {
                val (amountStr, merchant) = when (bankName) {
                     "Ziraat Bankası" -> {
                        // Ziraat regex only captures amount currently based on the simplified regex provided in plan
                        // Regex("""Harcamaniz:\s*(\d+[\.,]\d+)\s?TL""")
                        // Only 1 group captured
                        val amount = matchResult.groupValues[1]
                        Pair(amount, "Bilinmeyen İşyeri") // Merchant not captured in this specific regex yet
                    }
                    else -> {
                         // Other regexes have 2 groups: Amount and Merchant
                         Pair(matchResult.groupValues[1], matchResult.groupValues[2])
                    }
                }

                return Transaction(
                    date = timestamp,
                    amount = parseAmount(amountStr),
                    source = "SMS",
                    merchantName = merchant.trim(),
                    originalMessage = message
                )
            }
        }
        return null
    }

    private fun parseAmount(amountStr: String): Double {
        return try {
            // Handle Turkish format (comma as decimal separator)
            val normalized = amountStr.replace(".", "").replace(',', '.')
            if (normalized.contains('.')) {
                 normalized.toDouble()
            } else {
                 // Fallback for cases where it might be formatted differently or purely integer
                 amountStr.replace(',', '.').toDouble()
            }
        } catch (e: Exception) {
             // Second attempt with strict Locale
             try {
                 val format = NumberFormat.getInstance(Locale("tr", "TR"))
                 format.parse(amountStr)?.toDouble() ?: 0.0
             } catch (e2: Exception) {
                 0.0
             }
        }
    }
}
