package com.finradar.android.domain.model

data class Subscription(
    val id: Long = 0,
    val name: String,
    val averageAmount: Double,
    val totalPaidAmount: Double = averageAmount,
    val paymentCount: Int = 1,
    val lastPaymentDate: Long,
    val nextPaymentDate: Long = 0L,   // 0 = not set
    val category: String? = null,
    val isActive: Boolean = true
) {
    /**
     * Yeni bir ödeme yapıldığında toplam tutar ve ödeme sayısını saklayarak
     * (toplamTutar / ödemeAdedi) formülüyle gerçek ortalamayı hesaplar.
     */
    fun withNewPayment(amount: Double, paymentDate: Long = System.currentTimeMillis()): Subscription {
        val newCount = paymentCount + 1
        val newTotal = totalPaidAmount + amount
        return copy(
            paymentCount = newCount,
            totalPaidAmount = newTotal,
            averageAmount = newTotal / newCount,
            lastPaymentDate = paymentDate
        )
    }
}
