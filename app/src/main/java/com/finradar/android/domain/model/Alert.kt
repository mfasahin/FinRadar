package com.finradar.android.domain.model

data class Alert(
    val id: Long = 0,
    val subscriptionId: Long,
    val oldAmount: Double,
    val newAmount: Double,
    val percentageChange: Double,
    val isRead: Boolean = false,
    val date: Long
)
