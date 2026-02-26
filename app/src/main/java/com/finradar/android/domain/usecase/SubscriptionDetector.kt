package com.finradar.android.domain.usecase

import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.model.Transaction
import com.finradar.android.domain.repository.TransactionRepository
import javax.inject.Inject
import kotlin.math.abs

class SubscriptionDetector @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    private val whitelist = setOf(
        "netflix", "spotify", "youtube premium", "aws", "adobe", "apple", "microsoft 365", "exxen", "blutv", "google storage", "icloud"
    )

    private val keywords = mapOf(
        "abonelik" to 40,
        "yenilendi" to 30,
        "tekrarlı" to 30,
        "aidat" to 25,
        "periyodik" to 20,
        "talimatı" to 15,
        "üye" to 10
    )

    private val THRESHOLD = 50

    suspend fun detectSubscription(transaction: Transaction): Subscription? {
        var score = 0

        // 1. Check Whitelist (Instant Match)
        if (whitelist.any { transaction.merchantName.contains(it, ignoreCase = true) }) {
            score += 100
        }

        // 2. Keyword Analysis
        val content = transaction.originalMessage.lowercase()
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
