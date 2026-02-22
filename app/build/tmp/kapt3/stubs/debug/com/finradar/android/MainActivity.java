package com.finradar.android;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.ui.Modifier;
import androidx.core.content.ContextCompat;
import androidx.work.*;
import com.finradar.android.notification.NotificationHelper;
import com.finradar.android.presentation.settings.SettingsViewModel;
import com.finradar.android.worker.PaymentReminderWorker;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import com.finradar.android.data.preferences.UserPreferencesRepository;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/finradar/android/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "settingsViewModel", "Lcom/finradar/android/presentation/settings/SettingsViewModel;", "getSettingsViewModel", "()Lcom/finradar/android/presentation/settings/SettingsViewModel;", "settingsViewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy settingsViewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.finradar.android.presentation.settings.SettingsViewModel getSettingsViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull()
    android.content.Context newBase) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}