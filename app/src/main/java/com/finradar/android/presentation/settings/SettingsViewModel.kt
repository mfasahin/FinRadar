package com.finradar.android.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finradar.android.data.preferences.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val prefsRepo: UserPreferencesRepository
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

    /**
     * Suspend version — caller awaits this before calling activity.recreate(),
     * guaranteeing the synchronous SharedPrefs commit has completed.
     */
    suspend fun setLanguageAndWait(code: String) {
        prefsRepo.setLanguageCode(code)
    }
}
