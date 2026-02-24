package com.finradar.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.finradar.android.data.local.entity.SubscriptionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubscriptionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubscription(subscription: SubscriptionEntity): Long

    @Update
    suspend fun updateSubscription(subscription: SubscriptionEntity)

    @Query("UPDATE subscriptions SET isActive = 0 WHERE id = :id")
    suspend fun softDeleteSubscription(id: Long)

    @Query("UPDATE subscriptions SET nextPaymentDate = :newDate WHERE id = :id")
    suspend fun updateNextPaymentDate(id: Long, newDate: Long)

    @Query("SELECT * FROM subscriptions WHERE isActive = 1 ORDER BY averageAmount DESC")
    fun getActiveSubscriptions(): Flow<List<SubscriptionEntity>>

    @Query("SELECT * FROM subscriptions WHERE id = :id LIMIT 1")
    suspend fun getSubscriptionById(id: Long): SubscriptionEntity?

    @Query("SELECT * FROM subscriptions WHERE name = :name LIMIT 1")
    suspend fun getSubscriptionByName(name: String): SubscriptionEntity?
}
