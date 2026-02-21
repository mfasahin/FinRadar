package com.finradar.android.domain.usecase

import com.finradar.android.domain.model.Alert
import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.model.Transaction
import javax.inject.Inject

class PriceHikeDetector @Inject constructor() {

    fun checkPriceHike(transaction: Transaction, subscription: Subscription): Alert? {
        val oldAmount = subscription.averageAmount
        val newAmount = transaction.amount
        
        // If new amount is greater than old amount by more than 5%
        if (newAmount > oldAmount) {
            val increase = newAmount - oldAmount
            val percentage = (increase / oldAmount) * 100
            
            if (percentage > 5.0) {
                return Alert(
                    subscriptionId = subscription.id,
                    oldAmount = oldAmount,
                    newAmount = newAmount,
                    percentageChange = percentage,
                    date = transaction.date,
                    isRead = false
                )
            }
        }
        return null
    }
}
