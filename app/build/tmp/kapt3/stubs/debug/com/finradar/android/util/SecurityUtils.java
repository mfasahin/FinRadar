package com.finradar.android.util;

import android.content.Context;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/finradar/android/util/SecurityUtils;", "", "()V", "KEY_DB_PASSPHRASE", "", "PREFS_FILE", "getDatabasePassphrase", "context", "Landroid/content/Context;", "app_debug"})
public final class SecurityUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_FILE = "secure_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DB_PASSPHRASE = "db_passphrase";
    @org.jetbrains.annotations.NotNull()
    public static final com.finradar.android.util.SecurityUtils INSTANCE = null;
    
    private SecurityUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDatabasePassphrase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}