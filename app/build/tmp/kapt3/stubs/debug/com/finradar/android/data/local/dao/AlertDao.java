package com.finradar.android.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.finradar.android.data.local.entity.AlertEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\'J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\'J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/finradar/android/data/local/dao/AlertDao;", "", "clearAllAlerts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countRemindersSince", "", "subId", "", "since", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAlert", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlerts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/data/local/entity/AlertEntity;", "getUnreadAlertCount", "insertAlert", "alert", "(Lcom/finradar/android/data/local/entity/AlertEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface AlertDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAlert(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.entity.AlertEntity alert, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM alerts ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.data.local.entity.AlertEntity>> getAllAlerts();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM alerts WHERE isRead = 0")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getUnreadAlertCount();
    
    @androidx.room.Query(value = "DELETE FROM alerts WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAlert(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM alerts")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearAllAlerts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM alerts WHERE subscriptionId = :subId AND type = \'PAYMENT_REMINDER\' AND date >= :since")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countRemindersSince(long subId, long since, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}