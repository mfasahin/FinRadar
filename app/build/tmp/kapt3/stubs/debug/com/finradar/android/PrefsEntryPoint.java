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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/finradar/android/PrefsEntryPoint;", "", "userPreferencesRepository", "Lcom/finradar/android/data/preferences/UserPreferencesRepository;", "app_debug"})
@dagger.hilt.EntryPoint()
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract interface PrefsEntryPoint {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.finradar.android.data.preferences.UserPreferencesRepository userPreferencesRepository();
}