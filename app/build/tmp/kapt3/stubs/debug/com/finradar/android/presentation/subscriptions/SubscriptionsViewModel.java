package com.finradar.android.presentation.subscriptions;

import androidx.lifecycle.ViewModel;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.repository.SubscriptionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/finradar/android/presentation/subscriptions/SubscriptionsViewModel;", "Landroidx/lifecycle/ViewModel;", "subscriptionRepository", "Lcom/finradar/android/domain/repository/SubscriptionRepository;", "(Lcom/finradar/android/domain/repository/SubscriptionRepository;)V", "subscriptions", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/finradar/android/domain/model/Subscription;", "getSubscriptions", "()Lkotlinx/coroutines/flow/StateFlow;", "addSubscription", "", "name", "", "amount", "", "category", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SubscriptionsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.finradar.android.domain.model.Subscription>> subscriptions = null;
    
    @javax.inject.Inject()
    public SubscriptionsViewModel(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.finradar.android.domain.model.Subscription>> getSubscriptions() {
        return null;
    }
    
    public final void addSubscription(@org.jetbrains.annotations.NotNull()
    java.lang.String name, double amount, @org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
}