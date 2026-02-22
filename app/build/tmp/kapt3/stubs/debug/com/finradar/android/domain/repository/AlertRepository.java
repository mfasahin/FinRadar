package com.finradar.android.domain.repository;

import com.finradar.android.domain.model.Alert;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH&J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/finradar/android/domain/repository/AlertRepository;", "", "clearAllAlerts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAlert", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlerts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Alert;", "getUnreadAlertCount", "", "hasReminderBeenSentToday", "", "subscriptionId", "saveAlert", "alert", "(Lcom/finradar/android/domain/model/Alert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AlertRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveAlert(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Alert alert, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.domain.model.Alert>> getAllAlerts();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getUnreadAlertCount();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object hasReminderBeenSentToday(long subscriptionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAlert(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearAllAlerts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}