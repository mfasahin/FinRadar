package com.finradar.android.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.finradar.android.data.local.dao.AlertDao;
import com.finradar.android.data.local.dao.SubscriptionDao;
import com.finradar.android.data.local.dao.TransactionDao;
import com.finradar.android.data.local.entity.AlertEntity;
import com.finradar.android.data.local.entity.SubscriptionEntity;
import com.finradar.android.data.local.entity.TransactionEntity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/finradar/android/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "alertDao", "Lcom/finradar/android/data/local/dao/AlertDao;", "subscriptionDao", "Lcom/finradar/android/data/local/dao/SubscriptionDao;", "transactionDao", "Lcom/finradar/android/data/local/dao/TransactionDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.finradar.android.data.local.entity.TransactionEntity.class, com.finradar.android.data.local.entity.SubscriptionEntity.class, com.finradar.android.data.local.entity.AlertEntity.class}, version = 4, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "finradar_db";
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_3_4 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.finradar.android.data.local.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.finradar.android.data.local.dao.TransactionDao transactionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.finradar.android.data.local.dao.SubscriptionDao subscriptionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.finradar.android.data.local.dao.AlertDao alertDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/finradar/android/data/local/AppDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "MIGRATION_3_4", "Landroidx/room/migration/Migration;", "getMIGRATION_3_4", "()Landroidx/room/migration/Migration;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_3_4() {
            return null;
        }
    }
}