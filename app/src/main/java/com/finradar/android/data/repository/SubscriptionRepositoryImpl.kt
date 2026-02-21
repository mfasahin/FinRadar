package com.finradar.android.data.repository

import com.finradar.android.data.local.dao.SubscriptionDao
import com.finradar.android.data.local.entity.SubscriptionEntity
import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.repository.SubscriptionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SubscriptionRepositoryImpl @Inject constructor(
    private val dao: SubscriptionDao
) : SubscriptionRepository {

    override suspend fun saveSubscription(subscription: Subscription): Long {
        return dao.insertSubscription(subscription.toEntity())
    }

    override suspend fun updateSubscription(subscription: Subscription) {
        dao.updateSubscription(subscription.toEntity())
    }

    override suspend fun deleteSubscription(id: Long) {
        dao.softDeleteSubscription(id)
    }

    override suspend fun getSubscriptionById(id: Long): Subscription? {
        return dao.getSubscriptionById(id)?.toDomain()
    }

    override fun getActiveSubscriptions(): Flow<List<Subscription>> {
        return dao.getActiveSubscriptions().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun getSubscriptionByName(name: String): Subscription? {
        return dao.getSubscriptionByName(name)?.toDomain()
    }

    // ── Helpers ────────────────────────────────────────────────────────────
    private fun Subscription.toEntity() = SubscriptionEntity(
        id = id,
        name = name,
        averageAmount = averageAmount,
        lastPaymentDate = lastPaymentDate,
        category = category,
        isActive = isActive
    )

    private fun SubscriptionEntity.toDomain() = Subscription(
        id = id,
        name = name,
        averageAmount = averageAmount,
        lastPaymentDate = lastPaymentDate,
        category = category,
        isActive = isActive
    )
}
