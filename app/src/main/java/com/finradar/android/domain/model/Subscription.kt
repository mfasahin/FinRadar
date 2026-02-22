package com.finradar.android.domain.model

data class Subscription(
    val id: Long = 0,
    val name: String,
    val averageAmount: Double,
    val lastPaymentDate: Long,
    val nextPaymentDate: Long = 0L,   // 0 = not set
    val category: String? = null,
    val isActive: Boolean = true
)
