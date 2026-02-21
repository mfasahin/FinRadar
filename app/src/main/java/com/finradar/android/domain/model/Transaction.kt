package com.finradar.android.domain.model

data class Transaction(
    val id: Long = 0,
    val date: Long,
    val amount: Double,
    val source: String, // "SMS" or "Notification"
    val merchantName: String,
    val category: String? = null,
    val originalMessage: String
)
