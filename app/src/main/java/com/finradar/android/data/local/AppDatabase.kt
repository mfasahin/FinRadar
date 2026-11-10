package com.finradar.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.finradar.android.data.local.dao.AlertDao
import com.finradar.android.data.local.dao.SubscriptionDao
import com.finradar.android.data.local.entity.AlertEntity
import com.finradar.android.data.local.entity.SubscriptionEntity

@Database(
    entities = [SubscriptionEntity::class, AlertEntity::class],
    version = 5,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun subscriptionDao(): SubscriptionDao
    abstract fun alertDao(): AlertDao

    companion object {
        const val DATABASE_NAME = "finradar_db"

        /** v3 → v4: 'type' kolonu alerts tablosuna eklenmişti. */
        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE alerts ADD COLUMN type TEXT NOT NULL DEFAULT 'PRICE_CHANGE'"
                )
            }
        }

        /**
         * v4 → v5:
         * - SMS/bildirim tabanlı işlem takibi kaldırıldı: transactions tablosu silindi.
         * - Gerçek ortalama hesabı için totalPaidAmount ve paymentCount eklendi.
         */
        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // 1. transactions tablosunu kaldır (artık kullanılmıyor)
                db.execSQL("DROP TABLE IF EXISTS transactions")

                // 2. subscriptions tablosuna doğru ortalama hesabı için kolonları ekle
                db.execSQL("ALTER TABLE subscriptions ADD COLUMN totalPaidAmount REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE subscriptions ADD COLUMN paymentCount INTEGER NOT NULL DEFAULT 1")
                db.execSQL("UPDATE subscriptions SET totalPaidAmount = averageAmount WHERE totalPaidAmount = 0.0")
            }
        }
    }
}
