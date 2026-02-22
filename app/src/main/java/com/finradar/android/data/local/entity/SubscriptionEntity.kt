package com.finradar.android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriptions")
data class SubscriptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val averageAmount: Double,
    val lastPaymentDate: Long,
    val nextPaymentDate: Long = 0L,
    val category: String? = null,
    val isActive: Boolean = true
)
