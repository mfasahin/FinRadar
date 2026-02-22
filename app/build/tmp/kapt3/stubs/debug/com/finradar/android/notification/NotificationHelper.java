package com.finradar.android.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.finradar.android.MainActivity;
import com.finradar.android.R;
import java.text.NumberFormat;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ.\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/finradar/android/notification/NotificationHelper;", "", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "createChannel", "", "context", "Landroid/content/Context;", "sendPaymentReminder", "subscriptionId", "", "subscriptionName", "amount", "", "daysLeft", "app_debug"})
public final class NotificationHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CHANNEL_ID = "payment_reminders";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CHANNEL_NAME = "\u00d6deme Hat\u0131rlat\u0131c\u0131lar\u0131";
    @org.jetbrains.annotations.NotNull()
    public static final com.finradar.android.notification.NotificationHelper INSTANCE = null;
    
    private NotificationHelper() {
        super();
    }
    
    public final void createChannel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void sendPaymentReminder(@org.jetbrains.annotations.NotNull()
    android.content.Context context, long subscriptionId, @org.jetbrains.annotations.NotNull()
    java.lang.String subscriptionName, double amount, long daysLeft) {
    }
}