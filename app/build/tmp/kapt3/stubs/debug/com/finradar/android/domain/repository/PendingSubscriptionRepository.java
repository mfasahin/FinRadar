package com.finradar.android.domain.repository;

import com.finradar.android.domain.model.Subscription;
import kotlinx.coroutines.flow.Flow;

/**
 * Holds a subscription detected from SMS/notification until the user confirms or dismisses.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H&J\u0018\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u00a6@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/finradar/android/domain/repository/PendingSubscriptionRepository;", "", "clearPending", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingSubscription", "Lkotlinx/coroutines/flow/Flow;", "Lcom/finradar/android/domain/model/Subscription;", "setPendingSubscription", "subscription", "(Lcom/finradar/android/domain/model/Subscription;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PendingSubscriptionRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.finradar.android.domain.model.Subscription> getPendingSubscription();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setPendingSubscription(@org.jetbrains.annotations.Nullable()
    com.finradar.android.domain.model.Subscription subscription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearPending(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}