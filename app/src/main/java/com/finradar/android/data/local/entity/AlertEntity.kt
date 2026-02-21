package com.finradar.android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alerts")
data class AlertEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val subscriptionId: Long,
    val oldAmount: Double,
    val newAmount: Double,
    val percentageChange: Double,
    val isRead: Boolean = false,
    val date: Long
)
