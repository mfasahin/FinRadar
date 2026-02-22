package com.finradar.android.presentation.common;

import androidx.annotation.StringRes;
import androidx.compose.runtime.Composable;
import com.finradar.android.R;

/**
 * Maps stable internal category keys (stored in DB) to localized string resources.
 * Also handles backward-compat for databases that previously stored Turkish display strings.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/finradar/android/presentation/common/CategoryMapper;", "", "()V", "keys", "", "", "getKeys", "()Ljava/util/List;", "legacyToKey", "", "resIdFor", "", "key", "toKey", "stored", "app_debug"})
public final class CategoryMapper {
    
    /**
     * Stable keys — order determines the UI list order.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> keys = null;
    
    /**
     * Legacy: older rows were stored as Turkish display strings.
     * This map lets us translate those to canonical keys.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, java.lang.String> legacyToKey = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.finradar.android.presentation.common.CategoryMapper INSTANCE = null;
    
    private CategoryMapper() {
        super();
    }
    
    /**
     * Stable keys — order determines the UI list order.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getKeys() {
        return null;
    }
    
    /**
     * Internal key → string resource id
     */
    @androidx.annotation.StringRes()
    public final int resIdFor(@org.jetbrains.annotations.Nullable()
    java.lang.String key) {
        return 0;
    }
    
    /**
     * Converts whatever is stored in the DB (key or legacy Turkish string)
     * to a canonical key.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toKey(@org.jetbrains.annotations.Nullable()
    java.lang.String stored) {
        return null;
    }
}