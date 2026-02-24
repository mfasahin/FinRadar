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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/finradar/android/presentation/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "subscriptionRepository", "Lcom/finradar/android/domain/repository/SubscriptionRepository;", "alertRepository", "Lcom/finradar/android/domain/repository/AlertRepository;", "(Lcom/finradar/android/domain/repository/SubscriptionRepository;Lcom/finradar/android/domain/repository/AlertRepository;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/finradar/android/presentation/dashboard/DashboardUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.finradar.android.presentation.dashboard.DashboardUiState> uiState = null;
    
    @javax.inject.Inject()
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.AlertRepository alertRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.finradar.android.presentation.dashboard.DashboardUiState> getUiState() {
        return null;
    }
}