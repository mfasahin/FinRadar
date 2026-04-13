package com.finradar.android.data.parser;

import com.finradar.android.domain.model.Transaction;
import java.text.NumberFormat;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u00a2\u0006\u0002\u0010\tJ(\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/finradar/android/data/parser/NotificationParser;", "", "()V", "brands", "", "", "extractAmount", "", "text", "(Ljava/lang/String;)Ljava/lang/Double;", "parseNotification", "Lcom/finradar/android/domain/model/Transaction;", "packageName", "title", "timestamp", "", "app_debug"})
public final class NotificationParser {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> brands = null;
    
    public NotificationParser() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finradar.android.domain.model.Transaction parseNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String text, long timestamp) {
        return null;
    }
    
    private final java.lang.Double extractAmount(java.lang.String text) {
        return null;
    }
}