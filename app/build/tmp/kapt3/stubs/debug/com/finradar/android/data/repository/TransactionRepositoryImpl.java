package com.finradar.android.data.repository;

import com.finradar.android.data.local.dao.TransactionDao;
import com.finradar.android.data.local.entity.TransactionEntity;
import com.finradar.android.domain.model.Transaction;
import com.finradar.android.domain.repository.TransactionRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/finradar/android/data/repository/TransactionRepositoryImpl;", "Lcom/finradar/android/domain/repository/TransactionRepository;", "dao", "Lcom/finradar/android/data/local/dao/TransactionDao;", "(Lcom/finradar/android/data/local/dao/TransactionDao;)V", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finradar/android/domain/model/Transaction;", "getTransactionsByMerchant", "merchantName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTransaction", "", "transaction", "(Lcom/finradar/android/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TransactionRepositoryImpl implements com.finradar.android.domain.repository.TransactionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.data.local.dao.TransactionDao dao = null;
    
    @javax.inject.Inject()
    public TransactionRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.dao.TransactionDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveTransaction(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.finradar.android.domain.model.Transaction>> getAllTransactions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTransactionsByMerchant(@org.jetbrains.annotations.NotNull()
    java.lang.String merchantName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.finradar.android.domain.model.Transaction>> $completion) {
        return null;
    }
}