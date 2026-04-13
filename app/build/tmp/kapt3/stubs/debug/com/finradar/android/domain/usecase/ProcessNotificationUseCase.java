package com.finradar.android.domain.usecase;

import com.finradar.android.data.parser.NotificationParser;
import com.finradar.android.domain.repository.AlertRepository;
import com.finradar.android.domain.repository.PendingSubscriptionRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
import com.finradar.android.domain.repository.TransactionRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0086B\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/finradar/android/domain/usecase/ProcessNotificationUseCase;", "", "notificationParser", "Lcom/finradar/android/data/parser/NotificationParser;", "transactionRepository", "Lcom/finradar/android/domain/repository/TransactionRepository;", "subscriptionRepository", "Lcom/finradar/android/domain/repository/SubscriptionRepository;", "pendingSubscriptionRepository", "Lcom/finradar/android/domain/repository/PendingSubscriptionRepository;", "alertRepository", "Lcom/finradar/android/domain/repository/AlertRepository;", "subscriptionDetector", "Lcom/finradar/android/domain/usecase/SubscriptionDetector;", "priceHikeDetector", "Lcom/finradar/android/domain/usecase/PriceHikeDetector;", "(Lcom/finradar/android/data/parser/NotificationParser;Lcom/finradar/android/domain/repository/TransactionRepository;Lcom/finradar/android/domain/repository/SubscriptionRepository;Lcom/finradar/android/domain/repository/PendingSubscriptionRepository;Lcom/finradar/android/domain/repository/AlertRepository;Lcom/finradar/android/domain/usecase/SubscriptionDetector;Lcom/finradar/android/domain/usecase/PriceHikeDetector;)V", "invoke", "", "packageName", "", "title", "text", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ProcessNotificationUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.data.parser.NotificationParser notificationParser = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.PendingSubscriptionRepository pendingSubscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.AlertRepository alertRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.usecase.SubscriptionDetector subscriptionDetector = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.usecase.PriceHikeDetector priceHikeDetector = null;
    
    @javax.inject.Inject()
    public ProcessNotificationUseCase(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.parser.NotificationParser notificationParser, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.TransactionRepository transactionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.SubscriptionRepository subscriptionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.PendingSubscriptionRepository pendingSubscriptionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.AlertRepository alertRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.usecase.SubscriptionDetector subscriptionDetector, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.usecase.PriceHikeDetector priceHikeDetector) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String text, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}