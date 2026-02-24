package com.finradar.android.domain.repository;

import com.finradar.android.domain.model.Transaction;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/finradar/android/domain/repository/TransactionRepository;", "", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Transaction;", "getTransactionsByMerchant", "merchantName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTransactionDuplicate", "", "message", "date", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTransaction", "", "transaction", "(Lcom/finradar/android/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface TransactionRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveTransaction(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.domain.model.Transaction>> getAllTransactions();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsByMerchant(@org.jetbrains.annotations.NotNull()
    java.lang.String merchantName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.finradar.android.domain.model.Transaction>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isTransactionDuplicate(@org.jetbrains.annotations.NotNull()
    java.lang.String message, long date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}