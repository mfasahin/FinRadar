package com.finradar.android.service;

import android.service.notification.StatusBarNotification;
import android.util.Log;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/finradar/android/service/NotificationListenerService;", "Landroid/service/notification/NotificationListenerService;", "()V", "processIncomingSmsUseCase", "Ldagger/Lazy;", "Lcom/finradar/android/domain/usecase/ProcessIncomingSmsUseCase;", "getProcessIncomingSmsUseCase", "()Ldagger/Lazy;", "setProcessIncomingSmsUseCase", "(Ldagger/Lazy;)V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "onDestroy", "", "onListenerConnected", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "onNotificationRemoved", "app_debug"})
public final class NotificationListenerService extends android.service.notification.NotificationListenerService {
    @javax.inject.Inject()
    public dagger.Lazy<com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase> processIncomingSmsUseCase;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    
    public NotificationListenerService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dagger.Lazy<com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase> getProcessIncomingSmsUseCase() {
        return null;
    }
    
    public final void setProcessIncomingSmsUseCase(@org.jetbrains.annotations.NotNull()
    dagger.Lazy<com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase> p0) {
    }
    
    @java.lang.Override()
    public void onListenerConnected() {
    }
    
    @java.lang.Override()
    public void onNotificationPosted(@org.jetbrains.annotations.Nullable()
    android.service.notification.StatusBarNotification sbn) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onNotificationRemoved(@org.jetbrains.annotations.Nullable()
    android.service.notification.StatusBarNotification sbn) {
    }
}