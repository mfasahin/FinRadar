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
        "netflix", "spotify", "youtube premium", "aws", "adobe", "apple", "microsoft 365", "exxen", "blutv"
    )

    suspend fun detectSubscription(transaction: Transaction): Subscription? {
        // 1. Check Whitelist
        if (whitelist.any { transaction.merchantName.contains(it, ignoreCase = true) }) {
            return createSubscriptionFromTransaction(transaction)
        }

        // 2. Check Recursive Payment (Same merchant, amount ±2%, roughly monthly)
        // This is a simplified check for MVP: Check if there is a past transaction from same merchant with similar amount
        // ideally checking for ~30 days, but just finding ONE similar pattern is a strong indicator for MVP
        val history = transactionRepository.getTransactionsByMerchant(transaction.merchantName)
        
        // Filter out the current transaction if it's already saved (though usually this runs before or after saving)
        // Assuming this runs after saving, we check for *other* transactions
        val similarTransactions = history.filter { pastTx ->
            pastTx.id != transaction.id && isAmountSimilar(transaction.amount, pastTx.amount)
        }

        if (similarTransactions.isNotEmpty()) {
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
