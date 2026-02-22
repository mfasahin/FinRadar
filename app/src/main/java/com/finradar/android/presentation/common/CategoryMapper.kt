package com.finradar.android.presentation.common

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.finradar.android.R

/**
 * Maps stable internal category keys (stored in DB) to localized string resources.
 * Also handles backward-compat for databases that previously stored Turkish display strings.
 */
object CategoryMapper {

    /** Stable keys — order determines the UI list order. */
    val keys = listOf(
        "streaming", "music", "software", "cloud",
        "gaming", "fitness", "education", "news", "general"
    )

    /** Internal key → string resource id */
    @StringRes
    fun resIdFor(key: String?): Int = when (key) {
        "streaming" -> R.string.cat_streaming
        "music"     -> R.string.cat_music
        "software"  -> R.string.cat_software
        "cloud"     -> R.string.cat_cloud
        "gaming"    -> R.string.cat_gaming
        "fitness"   -> R.string.cat_fitness
        "education" -> R.string.cat_education
        "news"      -> R.string.cat_news
        else        -> R.string.cat_general
    }

    /**
     * Legacy: older rows were stored as Turkish display strings.
     * This map lets us translate those to canonical keys.
     */
    private val legacyToKey = mapOf(
        "Yayın Hizmeti"  to "streaming",
        "Müzik"          to "music",
        "Yazılım"        to "software",
        "Bulut Depolama" to "cloud",
        "Oyun"           to "gaming",
        "Fitness"        to "fitness",
        "Eğitim"         to "education",
        "Haberler"       to "news",
        "Genel"          to "general"
    )

    /**
     * Converts whatever is stored in the DB (key or legacy Turkish string)
     * to a canonical key.
     */
    fun toKey(stored: String?): String {
        if (stored == null) return "general"
        if (stored in keys) return stored          // already a key
        return legacyToKey[stored] ?: "general"   // legacy → key, unknown → general
    }
}

/** Resolve a stored category value to the localized display label. */
@Composable
fun localizedCategory(stored: String?): String {
    val key = CategoryMapper.toKey(stored)
    return stringResource(CategoryMapper.resIdFor(key))
}
