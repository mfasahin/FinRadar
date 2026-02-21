package com.finradar.android.domain.repository;

import com.finradar.android.domain.model.Subscription;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/finradar/android/domain/repository/SubscriptionRepository;", "", "getActiveSubscriptions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Subscription;", "getSubscriptionByName", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSubscription", "", "subscription", "(Lcom/finradar/android/domain/model/Subscription;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SubscriptionRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveSubscription(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Subscription subscription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.domain.model.Subscription>> getActiveSubscriptions();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSubscriptionByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finradar.android.domain.model.Subscription> $completion);
}