package com.finradar.android.domain.model

enum class AlertType { PRICE_CHANGE, PAYMENT_REMINDER }

data class Alert(
    val id: Long = 0,
    val subscriptionId: Long,
    val subscriptionName: String = "",
    val oldAmount: Double = 0.0,
    val newAmount: Double = 0.0,
    val percentageChange: Double = 0.0,
    val isRead: Boolean = false,
    val date: Long,
    val type: AlertType = AlertType.PRICE_CHANGE
)
