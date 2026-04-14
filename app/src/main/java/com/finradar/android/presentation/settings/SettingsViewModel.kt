package com.finradar.android.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finradar.android.data.preferences.UserPreferencesRepository
import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.repository.PendingSubscriptionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val prefsRepo: UserPreferencesRepository,
    private val pendingSubscriptionRepository: PendingSubscriptionRepository,
    private val processNotificationUseCase: com.finradar.android.domain.usecase.ProcessNotificationUseCase
) : ViewModel() {

    val isDarkTheme: StateFlow<Boolean> = prefsRepo.isDarkTheme
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), false)

    val languageCode: StateFlow<String> = prefsRepo.languageCode
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "tr")

    val reminderDays: StateFlow<Int> = prefsRepo.reminderDays
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 3)

    fun toggleTheme() {
        viewModelScope.launch { prefsRepo.setDarkTheme(!isDarkTheme.value) }
    }

    fun setLanguage(code: String) {
        viewModelScope.launch { prefsRepo.setLanguageCode(code) }
    }

    fun setReminderDays(days: Int) {
        viewModelScope.launch { prefsRepo.setReminderDays(days) }
    }

    // ── Onboarding ────────────────────────────────────────────────────────
    // ── Onboarding ────────────────────────────────────────────────────────
    val isOnboardingCompleted: StateFlow<Boolean?> = prefsRepo.isOnboardingCompleted
        .stateIn(viewModelScope, SharingStarted.Eagerly, null) // null = loading; Eagerly = read DataStore immediately

    fun setOnboardingCompleted() {
        viewModelScope.launch { prefsRepo.setOnboardingCompleted(true) }
    }

    fun isPermissionGranted(): Boolean {
        return com.finradar.android.notification.NotificationHelper.isNotificationListenerEnabled(prefsRepo.context)
    }

    /**
     * Suspend version — caller awaits this before calling activity.recreate(),
     * guaranteeing the synchronous SharedPrefs commit has completed.
     */
    suspend fun setLanguageAndWait(code: String) {
        prefsRepo.setLanguageCode(code)
    }

    fun triggerMockNotification() {
        val ctx = prefsRepo.context
        com.finradar.android.notification.NotificationHelper.sendMockBankNotification(ctx)
    }

    fun triggerManualLogicTest() {
        viewModelScope.launch {
            processNotificationUseCase.invoke(
                packageName = "com.test",
                title = "Test Bank",
                text = "Kredi kartınızdan EXXEN aboneliği için 139.90 TL harcama yapılmıştır.",
                timestamp = System.currentTimeMillis()
            )
        }
    }
}
