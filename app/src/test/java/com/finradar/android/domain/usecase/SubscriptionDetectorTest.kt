package com.finradar.android.domain.usecase

import com.finradar.android.domain.model.Transaction
import com.finradar.android.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class SubscriptionDetectorTest {

    private val fakeRepository = object : TransactionRepository {
        var transactionsByMerchant = mutableListOf<Transaction>()
        
        override suspend fun saveTransaction(transaction: Transaction) {}
        override fun getAllTransactions(): Flow<List<Transaction>> = TODO()
        override suspend fun getTransactionsByMerchant(merchantName: String): List<Transaction> = transactionsByMerchant
        override suspend fun isTransactionDuplicate(message: String, date: Long): Boolean = false
    }

    private val detector = SubscriptionDetector(fakeRepository)

    @Test
    fun `detects whitelist merchant immediately`() = runBlocking {
        val tx = Transaction(
            date = 1000L,
            amount = 100.0,
            source = "SMS",
            merchantName = "Netflix",
            originalMessage = "Netflix odemeniz alindi"
        )
        val result = detector.detectSubscription(tx)
        assertNotNull(result)
        assertEquals("Netflix", result?.name)
    }

    @Test
    fun `detects non-whitelist merchant with subscription keyword`() = runBlocking {
        val tx = Transaction(
            date = 1000L,
            amount = 50.0,
            source = "SMS",
            merchantName = "Yemeksepeti",
            originalMessage = "Yemeksepeti abonelik yenilendi"
        )
        // Score: subscription (40) + yenilendi (30) = 70 (Threshold 50)
        val result = detector.detectSubscription(tx)
        assertNotNull(result)
    }

    @Test
    fun `detects non-whitelist merchant with aidat keyword`() = runBlocking {
        val tx = Transaction(
            date = 1000L,
            amount = 500.0,
            source = "SMS",
            merchantName = "Site Yonetimi",
            originalMessage = "Site aidat odemeniz onaylandi"
        )
        // Score: aidat (25) + history (0) = 25 (Low score, hidden history check)
        // Let's add history to make it pass
        fakeRepository.transactionsByMerchant = mutableListOf(
            Transaction(id = 1, date = 0L, amount = 500.0, source = "SMS", merchantName = "Site Yonetimi", originalMessage = "asdf")
        )
        // Score: aidat (25) + history (30) = 55 (Threshold 50)
        val result = detector.detectSubscription(tx)
        assertNotNull(result)
    }

    @Test
    fun `does not detect one-time purchase without keywords`() = runBlocking {
        val tx = Transaction(
            date = 1000L,
            amount = 1200.0,
            source = "SMS",
            merchantName = "Trendyol",
            originalMessage = "Trendyol'dan 1200 TL harcama yaptiniz"
        )
        val result = detector.detectSubscription(tx)
        assertNull(result)
    }
}
