package com.finradar.android.domain.usecase

import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.model.Transaction
import com.finradar.android.domain.repository.TransactionRepository
import javax.inject.Inject
import kotlin.math.abs
import java.util.Locale

class SubscriptionDetector @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    private val whitelist = setOf(
        "NETFLIX", "SPOTIFY", "YOUTUBE", "AWS", "ADOBE", "APPLE", "MICROSOFT", "EXXEN", "BLUTV", "GOOGLE", "ICLOUD"
    )

    private val keywords = mapOf(
        "ABONEL" to 40, // abonelik, aboneliği vs.
        "YENILE" to 30, // yenilendi, yenileme vs.
        "TEKRARLI" to 30,
        "AIDAT" to 25,
        "PERIYODIK" to 20,
        "TALIMAT" to 15,
        "ÜYE" to 10,
        "UYE" to 10
    )

    private val THRESHOLD = 50

    suspend fun detectSubscription(transaction: Transaction): Subscription? {
        var score = 0

        // 1. Check Whitelist (Instant Match)
        val normalizedMerchant = transaction.merchantName.replace("i", "I").replace("İ", "I").replace("ı", "I").uppercase(Locale.ENGLISH)
        if (whitelist.any { normalizedMerchant.contains(it) }) {
            score += 100
        }

        // 2. Keyword Analysis
        val content = transaction.originalMessage.replace("i", "I").replace("İ", "I").replace("ı", "I").uppercase(Locale.ENGLISH)
        keywords.forEach { (keyword, points) ->
            if (content.contains(keyword)) {
                score += points
            }
        }

        // 3. History Check
        val history = transactionRepository.getTransactionsByMerchant(transaction.merchantName)
        val similarTransactions = history.filter { pastTx ->
            pastTx.id != transaction.id && isAmountSimilar(transaction.amount, pastTx.amount)
        }
        
        if (similarTransactions.isNotEmpty()) {
            score += 30
        }

        if (score >= THRESHOLD) {
            return createSubscriptionFromTransaction(transaction)
        }

        return null
    }

    private fun isAmountSimilar(amount1: Double, amount2: Double): Boolean {
        val diff = abs(amount1 - amount2)
        val tolerance = amount1 * 0.02 // 2% tolerance
        return diff <= tolerance
    }

    private fun createSubscriptionFromTransaction(transaction: Transaction): Subscription {
        return Subscription(
            name = transaction.merchantName,
            averageAmount = transaction.amount,
            lastPaymentDate = transaction.date,
            category = transaction.category,
            isActive = true
        )
    }
}
