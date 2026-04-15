package com.finradar.android.presentation.dashboard;

import androidx.lifecycle.ViewModel;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.repository.AlertRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\rJ\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003JS\u0010\u001b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\f\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00d6\u0001J\t\u0010 \u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/finradar/android/presentation/dashboard/DashboardUiState;", "", "totalSpendByCurrency", "", "", "", "totalActiveCount", "", "topSubscriptions", "", "Lcom/finradar/android/domain/model/Subscription;", "upcomingPayments", "unreadAlertCount", "(Ljava/util/Map;ILjava/util/List;Ljava/util/List;I)V", "getTopSubscriptions", "()Ljava/util/List;", "getTotalActiveCount", "()I", "getTotalSpendByCurrency", "()Ljava/util/Map;", "getUnreadAlertCount", "getUpcomingPayments", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
public final class DashboardUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Double> totalSpendByCurrency = null;
    private final int totalActiveCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finradar.android.domain.model.Subscription> topSubscriptions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finradar.android.domain.model.Subscription> upcomingPayments = null;
    private final int unreadAlertCount = 0;
    
    public DashboardUiState(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Double> totalSpendByCurrency, int totalActiveCount, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finradar.android.domain.model.Subscription> topSubscriptions, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finradar.android.domain.model.Subscription> upcomingPayments, int unreadAlertCount) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Double> getTotalSpendByCurrency() {
        return null;
    }
    
    public final int getTotalActiveCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finradar.android.domain.model.Subscription> getTopSubscriptions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finradar.android.domain.model.Subscription> getUpcomingPayments() {
        return null;
    }
    
    public final int getUnreadAlertCount() {
        return 0;
    }
    
    public DashboardUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Double> component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finradar.android.domain.model.Subscription> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finradar.android.domain.model.Subscription> component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.presentation.dashboard.DashboardUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Double> totalSpendByCurrency, int totalActiveCount, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finradar.android.domain.model.Subscription> topSubscriptions, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finradar.android.domain.model.Subscription> upcomingPayments, int unreadAlertCount) {
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