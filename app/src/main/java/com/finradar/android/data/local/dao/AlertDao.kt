package com.finradar.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.finradar.android.data.local.entity.AlertEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlertDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlert(alert: AlertEntity): Long

    @Query("SELECT * FROM alerts ORDER BY date DESC")
    fun getAllAlerts(): Flow<List<AlertEntity>>

    @Query("SELECT COUNT(*) FROM alerts WHERE isRead = 0")
    fun getUnreadAlertCount(): Flow<Int>

    @Query("DELETE FROM alerts WHERE id = :id")
    suspend fun deleteAlert(id: Long)

    @Query("DELETE FROM alerts")
    suspend fun clearAllAlerts()

    @Query("SELECT COUNT(*) FROM alerts WHERE subscriptionId = :subId AND type = 'PAYMENT_REMINDER' AND date >= :since")
    suspend fun countRemindersSince(subId: Long, since: Long): Int
}
