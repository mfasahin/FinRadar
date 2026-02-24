package com.finradar.android.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

@Singleton
class UserPreferencesRepository @Inject constructor(
    @ApplicationContext val context: Context
) {
    companion object {
        private val IS_DARK_THEME  = booleanPreferencesKey("is_dark_theme")
        private val LANGUAGE_CODE  = stringPreferencesKey("language_code")
        private val REMINDER_DAYS  = intPreferencesKey("reminder_days")
        private val IS_ONBOARDING_COMPLETED = booleanPreferencesKey("is_onboarding_completed")
        private const val LANG_PREFS = "lang_pref"
        private const val LANG_KEY   = "lang"
    }

    // ── Dark theme ─────────────────────────────────────────────────────────
    val isDarkTheme: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[IS_DARK_THEME] ?: false }

    suspend fun setDarkTheme(enabled: Boolean) {
        context.dataStore.edit { prefs -> prefs[IS_DARK_THEME] = enabled }
    }

    // ── Language ───────────────────────────────────────────────────────────
    val languageCode: Flow<String> = context.dataStore.data
        .map { prefs -> prefs[LANGUAGE_CODE] ?: "tr" }

    /**
     * Writes the language code SYNCHRONOUSLY via commit() so it is available
     * when attachBaseContext reads it immediately after activity.recreate().
     * Also updates DataStore asynchronously for reactive UI.
     */
    suspend fun setLanguageCode(code: String) {
        // 1. Synchronous write — guarantees value is readable before recreate() runs
        context.getSharedPreferences(LANG_PREFS, Context.MODE_PRIVATE)
            .edit()
            .putString(LANG_KEY, code)
            .commit()                        // ← commit(), NOT apply()

        // 2. Async DataStore write for reactive LanguageCode flow
        context.dataStore.edit { prefs -> prefs[LANGUAGE_CODE] = code }
    }

    /** Synchronous read used in attachBaseContext before coroutines start. */
    fun getLanguageCodeSync(): String =
        context.getSharedPreferences(LANG_PREFS, Context.MODE_PRIVATE)
            .getString(LANG_KEY, "tr") ?: "tr"
    // ── Reminder days ──────────────────────────────────────────────────────
    val reminderDays: Flow<Int> = context.dataStore.data
        .map { prefs -> prefs[REMINDER_DAYS] ?: 3 }

    suspend fun setReminderDays(days: Int) {
        context.dataStore.edit { prefs -> prefs[REMINDER_DAYS] = days.coerceIn(1, 14) }
    }

    // ── Onboarding ────────────────────────────────────────────────────────
    val isOnboardingCompleted: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[IS_ONBOARDING_COMPLETED] ?: false }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { prefs -> prefs[IS_ONBOARDING_COMPLETED] = completed }
    }
}
