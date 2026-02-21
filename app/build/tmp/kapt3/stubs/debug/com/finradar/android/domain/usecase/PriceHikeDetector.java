package com.finradar.android.domain.usecase;

import com.finradar.android.domain.model.Alert;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.model.Transaction;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/finradar/android/domain/usecase/PriceHikeDetector;", "", "()V", "checkPriceHike", "Lcom/finradar/android/domain/model/Alert;", "transaction", "Lcom/finradar/android/domain/model/Transaction;", "subscription", "Lcom/finradar/android/domain/model/Subscription;", "app_debug"})
public final class PriceHikeDetector {
    
    @javax.inject.Inject()
    public PriceHikeDetector() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finradar.android.domain.model.Alert checkPriceHike(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Transaction transaction, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Subscription subscription) {
        return null;
    }
}