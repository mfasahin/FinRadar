package com.finradar.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.finradar.android.data.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: TransactionEntity): Long

    @Query("SELECT * FROM transactions ORDER BY date DESC")
    fun getAllTransactions(): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM transactions WHERE merchantName = :merchantName ORDER BY date DESC")
    suspend fun getTransactionsByMerchant(merchantName: String): List<TransactionEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM transactions WHERE originalMessage = :message AND date = :date)")
    suspend fun isTransactionDuplicate(message: String, date: Long): Boolean
}
