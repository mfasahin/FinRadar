package com.finradar.android.domain.usecase;

import com.finradar.android.data.parser.SmsParser;
import com.finradar.android.domain.repository.AlertRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
import com.finradar.android.domain.repository.TransactionRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0086B\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/finradar/android/domain/usecase/ProcessIncomingSmsUseCase;", "", "smsParser", "Lcom/finradar/android/data/parser/SmsParser;", "transactionRepository", "Lcom/finradar/android/domain/repository/TransactionRepository;", "subscriptionRepository", "Lcom/finradar/android/domain/repository/SubscriptionRepository;", "alertRepository", "Lcom/finradar/android/domain/repository/AlertRepository;", "subscriptionDetector", "Lcom/finradar/android/domain/usecase/SubscriptionDetector;", "priceHikeDetector", "Lcom/finradar/android/domain/usecase/PriceHikeDetector;", "(Lcom/finradar/android/data/parser/SmsParser;Lcom/finradar/android/domain/repository/TransactionRepository;Lcom/finradar/android/domain/repository/SubscriptionRepository;Lcom/finradar/android/domain/repository/AlertRepository;Lcom/finradar/android/domain/usecase/SubscriptionDetector;Lcom/finradar/android/domain/usecase/PriceHikeDetector;)V", "invoke", "", "sender", "", "message", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ProcessIncomingSmsUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.data.parser.SmsParser smsParser = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.AlertRepository alertRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.usecase.SubscriptionDetector subscriptionDetector = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.usecase.PriceHikeDetector priceHikeDetector = null;
    
    @javax.inject.Inject()
    public ProcessIncomingSmsUseCase(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.parser.SmsParser smsParser, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.TransactionRepository transactionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.AlertRepository alertRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.usecase.SubscriptionDetector subscriptionDetector, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.usecase.PriceHikeDetector priceHikeDetector) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String sender, @org.jetbrains.annotations.NotNull()
    java.lang.String message, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}