package com.finradar.android.presentation.dashboard;

import androidx.lifecycle.ViewModel;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.repository.AlertRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/finradar/android/presentation/dashboard/DashboardUiState;", "", "totalMonthlySpend", "", "topSubscriptions", "", "Lcom/finradar/android/domain/model/Subscription;", "unreadAlertCount", "", "(DLjava/util/List;I)V", "getTopSubscriptions", "()Ljava/util/List;", "getTotalMonthlySpend", "()D", "getUnreadAlertCount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class DashboardUiState {
    private final double totalMonthlySpend = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finradar.android.domain.model.Subscription> topSubscriptions = null;
    private final int unreadAlertCount = 0;
    
    public DashboardUiState(double totalMonthlySpend, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finradar.android.domain.model.Subscription> topSubscriptions, int unreadAlertCount) {
        super();
    }
    
    public final double getTotalMonthlySpend() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finradar.android.domain.model.Subscription> getTopSubscriptions() {
        return null;
    }
    
    public final int getUnreadAlertCount() {
        return 0;
    }
    
    public DashboardUiState() {
        super();
    }
    
    public final double component1() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finradar.android.domain.model.Subscription> component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.presentation.dashboard.DashboardUiState copy(double totalMonthlySpend, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finradar.android.domain.model.Subscription> topSubscriptions, int unreadAlertCount) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}