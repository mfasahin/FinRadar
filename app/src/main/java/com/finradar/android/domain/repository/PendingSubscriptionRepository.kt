package com.finradar.android.domain.repository

import com.finradar.android.domain.model.Subscription
import kotlinx.coroutines.flow.Flow

/**
 * Holds a subscription detected from SMS/notification until the user confirms or dismisses.
 */
interface PendingSubscriptionRepository {
    fun getPendingSubscription(): Flow<Subscription?>
    suspend fun setPendingSubscription(subscription: Subscription?)
    suspend fun clearPending()
}
