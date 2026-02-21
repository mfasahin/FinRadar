package com.finradar.android.domain.repository

import com.finradar.android.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

interface SubscriptionRepository {
    suspend fun saveSubscription(subscription: Subscription): Long
    fun getActiveSubscriptions(): Flow<List<Subscription>>
    suspend fun getSubscriptionByName(name: String): Subscription?
}
