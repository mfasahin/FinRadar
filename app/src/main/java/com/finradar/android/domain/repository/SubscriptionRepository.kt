package com.finradar.android.domain.repository

import com.finradar.android.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

interface SubscriptionRepository {
    suspend fun saveSubscription(subscription: Subscription): Long
    suspend fun updateSubscription(subscription: Subscription)
    suspend fun updateNextPaymentDate(id: Long, newDate: Long)
    suspend fun deleteSubscription(id: Long)
    suspend fun getSubscriptionById(id: Long): Subscription?
    fun getActiveSubscriptions(): Flow<List<Subscription>>
    suspend fun getSubscriptionByName(name: String): Subscription?
}
