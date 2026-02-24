package com.finradar.android.domain.usecase;

import android.content.Context;
import android.net.Uri;
import android.provider.Telephony;
import com.finradar.android.domain.repository.TransactionRepository;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\nH\u0086B\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/finradar/android/domain/usecase/ScanSmsHistoryUseCase;", "", "context", "Landroid/content/Context;", "processIncomingSmsUseCase", "Lcom/finradar/android/domain/usecase/ProcessIncomingSmsUseCase;", "transactionRepository", "Lcom/finradar/android/domain/repository/TransactionRepository;", "(Landroid/content/Context;Lcom/finradar/android/domain/usecase/ProcessIncomingSmsUseCase;Lcom/finradar/android/domain/repository/TransactionRepository;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ScanSmsHistoryUseCase {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase processIncomingSmsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.TransactionRepository transactionRepository = null;
    
    @javax.inject.Inject()
    public ScanSmsHistoryUseCase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase processIncomingSmsUseCase, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.TransactionRepository transactionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}