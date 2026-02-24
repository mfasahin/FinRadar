package com.finradar.android.util

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.util.UUID

object SecurityUtils {
    private const val PREFS_FILE = "secure_prefs"
    private const val KEY_DB_PASSPHRASE = "db_passphrase"

    fun getDatabasePassphrase(context: Context): String {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val sharedPrefs = EncryptedSharedPreferences.create(
            context,
            PREFS_FILE,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        var passphrase = sharedPrefs.getString(KEY_DB_PASSPHRASE, null)
        if (passphrase == null) {
            passphrase = UUID.randomUUID().toString() + UUID.randomUUID().toString()
            sharedPrefs.edit().putString(KEY_DB_PASSPHRASE, passphrase).apply()
        }
        return passphrase
    }
}
