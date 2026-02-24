package com.finradar.android.domain.repository

import com.finradar.android.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    suspend fun saveTransaction(transaction: Transaction)
    fun getAllTransactions(): Flow<List<Transaction>>
    suspend fun getTransactionsByMerchant(merchantName: String): List<Transaction>
    suspend fun isTransactionDuplicate(message: String, date: Long): Boolean
}
