package com.finradar.android.domain.repository;

import com.finradar.android.domain.model.Alert;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H&J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/finradar/android/domain/repository/AlertRepository;", "", "getAllAlerts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Alert;", "getUnreadAlertCount", "", "saveAlert", "", "alert", "(Lcom/finradar/android/domain/model/Alert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AlertRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveAlert(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Alert alert, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.domain.model.Alert>> getAllAlerts();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getUnreadAlertCount();
}