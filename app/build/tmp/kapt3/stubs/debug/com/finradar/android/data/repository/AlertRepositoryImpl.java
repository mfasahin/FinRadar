package com.finradar.android.data.repository;

import com.finradar.android.data.local.dao.AlertDao;
import com.finradar.android.data.local.entity.AlertEntity;
import com.finradar.android.domain.model.Alert;
import com.finradar.android.domain.model.AlertType;
import com.finradar.android.domain.repository.AlertRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\rH\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/finradar/android/data/repository/AlertRepositoryImpl;", "Lcom/finradar/android/domain/repository/AlertRepository;", "dao", "Lcom/finradar/android/data/local/dao/AlertDao;", "(Lcom/finradar/android/data/local/dao/AlertDao;)V", "clearAllAlerts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAlert", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlerts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Alert;", "getUnreadAlertCount", "", "hasReminderBeenSentToday", "", "subscriptionId", "saveAlert", "alert", "(Lcom/finradar/android/domain/model/Alert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AlertRepositoryImpl implements com.finradar.android.domain.repository.AlertRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.data.local.dao.AlertDao dao = null;
    
    @javax.inject.Inject()
    public AlertRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.dao.AlertDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveAlert(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Alert alert, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.domain.model.Alert>> getAllAlerts() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Integer> getUnreadAlertCount() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object hasReminderBeenSentToday(long subscriptionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteAlert(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object clearAllAlerts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}