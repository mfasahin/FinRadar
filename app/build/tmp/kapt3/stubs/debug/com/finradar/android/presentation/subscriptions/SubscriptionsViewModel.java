package com.finradar.android.presentation.subscriptions;

import androidx.lifecycle.ViewModel;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.repository.SubscriptionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u0015J.\u0010!\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\""}, d2 = {"Lcom/finradar/android/presentation/subscriptions/SubscriptionsViewModel;", "Landroidx/lifecycle/ViewModel;", "subscriptionRepository", "Lcom/finradar/android/domain/repository/SubscriptionRepository;", "scanSmsHistoryUseCase", "Lcom/finradar/android/domain/usecase/ScanSmsHistoryUseCase;", "(Lcom/finradar/android/domain/repository/SubscriptionRepository;Lcom/finradar/android/domain/usecase/ScanSmsHistoryUseCase;)V", "_editTarget", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/finradar/android/domain/model/Subscription;", "_isRefreshing", "", "editTarget", "Lkotlinx/coroutines/flow/StateFlow;", "getEditTarget", "()Lkotlinx/coroutines/flow/StateFlow;", "isRefreshing", "subscriptions", "", "getSubscriptions", "addSubscription", "", "name", "", "amount", "", "category", "nextPaymentDate", "", "deleteSubscription", "id", "loadForEdit", "refresh", "updateSubscription", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SubscriptionsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.usecase.ScanSmsHistoryUseCase scanSmsHistoryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.finradar.android.domain.model.Subscription>> subscriptions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.finradar.android.domain.model.Subscription> _editTarget = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.finradar.android.domain.model.Subscription> editTarget = null;
    
    @javax.inject.Inject()
    public SubscriptionsViewModel(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.usecase.ScanSmsHistoryUseCase scanSmsHistoryUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.finradar.android.domain.model.Subscription>> getSubscriptions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.finradar.android.domain.model.Subscription> getEditTarget() {
        return null;
    }
    
    public final void refresh() {
    }
    
    public final void addSubscription(@org.jetbrains.annotations.NotNull()
    java.lang.String name, double amount, @org.jetbrains.annotations.NotNull()
    java.lang.String category, long nextPaymentDate) {
    }
    
    public final void loadForEdit(long id) {
    }
    
    public final void updateSubscription(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double amount, @org.jetbrains.annotations.NotNull()
    java.lang.String category, long nextPaymentDate) {
    }
    
    public final void deleteSubscription(long id) {
    }
}