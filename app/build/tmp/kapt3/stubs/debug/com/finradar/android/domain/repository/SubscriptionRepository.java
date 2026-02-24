package com.finradar.android.domain.repository;

import com.finradar.android.domain.model.Subscription;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/finradar/android/domain/repository/SubscriptionRepository;", "", "deleteSubscription", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveSubscriptions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Subscription;", "getSubscriptionById", "getSubscriptionByName", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSubscription", "subscription", "(Lcom/finradar/android/domain/model/Subscription;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNextPaymentDate", "newDate", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "app_debug"})
public abstract interface SubscriptionRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveSubscription(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Subscription subscription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSubscription(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Subscription subscription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNextPaymentDate(long id, long newDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSubscription(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSubscriptionById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finradar.android.domain.model.Subscription> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.domain.model.Subscription>> getActiveSubscriptions();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSubscriptionByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finradar.android.domain.model.Subscription> $completion);
}