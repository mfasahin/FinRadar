package com.finradar.android.presentation.pending;

import androidx.lifecycle.ViewModel;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.repository.PendingSubscriptionRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/finradar/android/presentation/pending/PendingSubscriptionViewModel;", "Landroidx/lifecycle/ViewModel;", "pendingSubscriptionRepository", "Lcom/finradar/android/domain/repository/PendingSubscriptionRepository;", "subscriptionRepository", "Lcom/finradar/android/domain/repository/SubscriptionRepository;", "(Lcom/finradar/android/domain/repository/PendingSubscriptionRepository;Lcom/finradar/android/domain/repository/SubscriptionRepository;)V", "pendingSubscription", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/finradar/android/domain/model/Subscription;", "getPendingSubscription", "()Lkotlinx/coroutines/flow/StateFlow;", "confirmSave", "", "dismiss", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PendingSubscriptionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.PendingSubscriptionRepository pendingSubscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.finradar.android.domain.model.Subscription> pendingSubscription = null;
    
    @javax.inject.Inject()
    public PendingSubscriptionViewModel(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.PendingSubscriptionRepository pendingSubscriptionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.finradar.android.domain.model.Subscription> getPendingSubscription() {
        return null;
    }
    
    public final void confirmSave() {
    }
    
    public final void dismiss() {
    }
}