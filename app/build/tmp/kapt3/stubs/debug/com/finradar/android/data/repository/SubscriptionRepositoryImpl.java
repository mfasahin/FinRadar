package com.finradar.android.data.repository;

import com.finradar.android.data.local.dao.SubscriptionDao;
import com.finradar.android.data.local.entity.SubscriptionEntity;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.repository.SubscriptionRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0016J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0015J\f\u0010\u0017\u001a\u00020\r*\u00020\u0018H\u0002J\f\u0010\u0019\u001a\u00020\u0018*\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/finradar/android/data/repository/SubscriptionRepositoryImpl;", "Lcom/finradar/android/domain/repository/SubscriptionRepository;", "dao", "Lcom/finradar/android/data/local/dao/SubscriptionDao;", "(Lcom/finradar/android/data/local/dao/SubscriptionDao;)V", "deleteSubscription", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveSubscriptions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Subscription;", "getSubscriptionById", "getSubscriptionByName", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSubscription", "subscription", "(Lcom/finradar/android/domain/model/Subscription;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "toDomain", "Lcom/finradar/android/data/local/entity/SubscriptionEntity;", "toEntity", "app_debug"})
public final class SubscriptionRepositoryImpl implements com.finradar.android.domain.repository.SubscriptionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.data.local.dao.SubscriptionDao dao = null;
    
    @javax.inject.Inject()
    public SubscriptionRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.dao.SubscriptionDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveSubscription(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Subscription subscription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateSubscription(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Subscription subscription, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteSubscription(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSubscriptionById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finradar.android.domain.model.Subscription> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.domain.model.Subscription>> getActiveSubscriptions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSubscriptionByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finradar.android.domain.model.Subscription> $completion) {
        return null;
    }
    
    private final com.finradar.android.data.local.entity.SubscriptionEntity toEntity(com.finradar.android.domain.model.Subscription $this$toEntity) {
        return null;
    }
    
    private final com.finradar.android.domain.model.Subscription toDomain(com.finradar.android.data.local.entity.SubscriptionEntity $this$toDomain) {
        return null;
    }
}