package com.finradar.android.domain.usecase;

import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.model.Transaction;
import com.finradar.android.domain.repository.TransactionRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/finradar/android/domain/usecase/SubscriptionDetector;", "", "transactionRepository", "Lcom/finradar/android/domain/repository/TransactionRepository;", "(Lcom/finradar/android/domain/repository/TransactionRepository;)V", "THRESHOLD", "", "keywords", "", "", "whitelist", "", "createSubscriptionFromTransaction", "Lcom/finradar/android/domain/model/Subscription;", "transaction", "Lcom/finradar/android/domain/model/Transaction;", "detectSubscription", "(Lcom/finradar/android/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAmountSimilar", "", "amount1", "", "amount2", "app_debug"})
public final class SubscriptionDetector {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> whitelist = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Integer> keywords = null;
    private final int THRESHOLD = 50;
    
    @javax.inject.Inject()
    public SubscriptionDetector(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.TransactionRepository transactionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object detectSubscription(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finradar.android.domain.model.Subscription> $completion) {
        return null;
    }
    
    private final boolean isAmountSimilar(double amount1, double amount2) {
        return false;
    }
    
    private final com.finradar.android.domain.model.Subscription createSubscriptionFromTransaction(com.finradar.android.domain.model.Transaction transaction) {
        return null;
    }
}