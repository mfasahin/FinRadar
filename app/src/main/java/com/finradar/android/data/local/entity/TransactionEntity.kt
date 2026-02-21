package com.finradar.android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: Long,
    val amount: Double,
    val source: String, // SMS or Notification
    val merchantName: String,
    val category: String? = null,
    val originalMessage: String
)
