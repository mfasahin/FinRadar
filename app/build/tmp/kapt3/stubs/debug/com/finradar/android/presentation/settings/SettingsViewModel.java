package com.finradar.android.presentation.settings;

import androidx.lifecycle.ViewModel;
import com.finradar.android.data.preferences.UserPreferencesRepository;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.domain.repository.PendingSubscriptionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0016J\u0006\u0010\u001f\u001a\u00020\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/finradar/android/presentation/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "prefsRepo", "Lcom/finradar/android/data/preferences/UserPreferencesRepository;", "pendingSubscriptionRepository", "Lcom/finradar/android/domain/repository/PendingSubscriptionRepository;", "processNotificationUseCase", "Lcom/finradar/android/domain/usecase/ProcessNotificationUseCase;", "(Lcom/finradar/android/data/preferences/UserPreferencesRepository;Lcom/finradar/android/domain/repository/PendingSubscriptionRepository;Lcom/finradar/android/domain/usecase/ProcessNotificationUseCase;)V", "isDarkTheme", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "isOnboardingCompleted", "languageCode", "", "getLanguageCode", "reminderDays", "", "getReminderDays", "isPermissionGranted", "setLanguage", "", "code", "setLanguageAndWait", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOnboardingCompleted", "setReminderDays", "days", "toggleTheme", "triggerManualLogicTest", "triggerMockNotification", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.data.preferences.UserPreferencesRepository prefsRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.repository.PendingSubscriptionRepository pendingSubscriptionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finradar.android.domain.usecase.ProcessNotificationUseCase processNotificationUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkTheme = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> languageCode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> reminderDays = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOnboardingCompleted = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.preferences.UserPreferencesRepository prefsRepo, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.PendingSubscriptionRepository pendingSubscriptionRepository, @org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.usecase.ProcessNotificationUseCase processNotificationUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkTheme() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getLanguageCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getReminderDays() {
        return null;
    }
    
    public final void toggleTheme() {
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    public final void setReminderDays(int days) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOnboardingCompleted() {
        return null;
    }
    
    public final void setOnboardingCompleted() {
    }
    
    public final boolean isPermissionGranted() {
        return false;
    }
    
    /**
     * Suspend version — caller awaits this before calling activity.recreate(),
     * guaranteeing the synchronous SharedPrefs commit has completed.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setLanguageAndWait(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void triggerMockNotification() {
    }
    
    public final void triggerManualLogicTest() {
    }
}