package com.finradar.android.data.repository;

import com.finradar.android.data.local.dao.AlertDao;
import com.finradar.android.data.local.entity.AlertEntity;
import com.finradar.android.domain.model.Alert;
import com.finradar.android.domain.repository.AlertRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/finradar/android/data/repository/AlertRepositoryImpl;", "Lcom/finradar/android/domain/repository/AlertRepository;", "dao", "Lcom/finradar/android/data/local/dao/AlertDao;", "(Lcom/finradar/android/data/local/dao/AlertDao;)V", "getAllAlerts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Alert;", "getUnreadAlertCount", "", "saveAlert", "", "alert", "(Lcom/finradar/android/domain/model/Alert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
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
}