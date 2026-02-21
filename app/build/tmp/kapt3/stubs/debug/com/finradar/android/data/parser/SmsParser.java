package com.finradar.android.data.parser;

import com.finradar.android.domain.model.Transaction;
import java.text.NumberFormat;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2 = {"Lcom/finradar/android/data/parser/SmsParser;", "", "()V", "parseAmount", "", "amountStr", "", "parseSms", "Lcom/finradar/android/domain/model/Transaction;", "sender", "message", "timestamp", "", "app_debug"})
public final class SmsParser {
    
    public SmsParser() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finradar.android.domain.model.Transaction parseSms(@org.jetbrains.annotations.NotNull()
    java.lang.String sender, @org.jetbrains.annotations.NotNull()
    java.lang.String message, long timestamp) {
        return null;
    }
    
    private final double parseAmount(java.lang.String amountStr) {
        return 0.0;
    }
}