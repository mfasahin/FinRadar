package com.finradar.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.finradar.android.data.local.dao.AlertDao
import com.finradar.android.data.local.dao.SubscriptionDao
import com.finradar.android.data.local.dao.TransactionDao
import com.finradar.android.data.local.entity.AlertEntity
import com.finradar.android.data.local.entity.SubscriptionEntity
import com.finradar.android.data.local.entity.TransactionEntity

@Database(
    entities = [TransactionEntity::class, SubscriptionEntity::class, AlertEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun subscriptionDao(): SubscriptionDao
    abstract fun alertDao(): AlertDao

    companion object {
        const val DATABASE_NAME = "finradar_db"
    }
}
