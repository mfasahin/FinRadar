package com.finradar.android.service;

import android.service.notification.StatusBarNotification;
import android.util.Log;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/finradar/android/service/NotificationListenerService;", "Landroid/service/notification/NotificationListenerService;", "()V", "processIncomingSmsUseCase", "Lcom/finradar/android/domain/usecase/ProcessIncomingSmsUseCase;", "getProcessIncomingSmsUseCase", "()Lcom/finradar/android/domain/usecase/ProcessIncomingSmsUseCase;", "setProcessIncomingSmsUseCase", "(Lcom/finradar/android/domain/usecase/ProcessIncomingSmsUseCase;)V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "onDestroy", "", "onListenerConnected", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "onNotificationRemoved", "app_debug"})
public final class NotificationListenerService extends android.service.notification.NotificationListenerService {
    @javax.inject.Inject()
    public com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase processIncomingSmsUseCase;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    
    public NotificationListenerService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase getProcessIncomingSmsUseCase() {
        return null;
    }
    
    public final void setProcessIncomingSmsUseCase(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase p0) {
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