package com.finradar.android.data.repository

import com.finradar.android.data.local.dao.TransactionDao
import com.finradar.android.data.local.entity.TransactionEntity
import com.finradar.android.domain.model.Transaction
import com.finradar.android.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val dao: TransactionDao
) : TransactionRepository {

    override suspend fun saveTransaction(transaction: Transaction) {
        val entity = TransactionEntity(
            date = transaction.date,
            amount = transaction.amount,
            source = transaction.source,
            merchantName = transaction.merchantName,
            category = transaction.category,
            originalMessage = transaction.originalMessage
        )
        dao.insertTransaction(entity)
    }

    override fun getAllTransactions(): Flow<List<Transaction>> {
        return dao.getAllTransactions().map { entities ->
            entities.map { entity ->
                Transaction(
                    id = entity.id,
                    date = entity.date,
                    amount = entity.amount,
                    source = entity.source,
                    merchantName = entity.merchantName,
                    category = entity.category,
                    originalMessage = entity.originalMessage
                )
            }
        }
    }

    override suspend fun getTransactionsByMerchant(merchantName: String): List<Transaction> {
        return dao.getTransactionsByMerchant(merchantName).map { entity ->
            Transaction(
                id = entity.id,
                date = entity.date,
                amount = entity.amount,
                source = entity.source,
                merchantName = entity.merchantName,
                category = entity.category,
                originalMessage = entity.originalMessage
            )
        }
    }
}
