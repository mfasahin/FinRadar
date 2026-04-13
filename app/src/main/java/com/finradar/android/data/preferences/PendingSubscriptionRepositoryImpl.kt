package com.finradar.android.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.repository.PendingSubscriptionRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.pendingSubscriptionDataStore: DataStore<Preferences> by preferencesDataStore(name = "pending_subscription")

@Singleton
class PendingSubscriptionRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PendingSubscriptionRepository {

    companion object {
        private val PENDING_NAME = stringPreferencesKey("pending_sub_name")
        private val PENDING_AMOUNT = doublePreferencesKey("pending_sub_amount")
        private val PENDING_DATE = longPreferencesKey("pending_sub_date")
        private val PENDING_CATEGORY = stringPreferencesKey("pending_sub_category")
    }

    override fun getPendingSubscription(): Flow<Subscription?> = context.pendingSubscriptionDataStore.data.map { prefs ->
        val name = prefs[PENDING_NAME] ?: return@map null
        if (name.isBlank()) return@map null
        val amount = prefs[PENDING_AMOUNT] ?: return@map null
        val date = prefs[PENDING_DATE] ?: return@map null
        Subscription(
            id = 0,
            name = name,
            averageAmount = amount,
            lastPaymentDate = date,
            nextPaymentDate = 0L,
            category = prefs[PENDING_CATEGORY],
            isActive = true
        )
    }

    override suspend fun setPendingSubscription(subscription: Subscription?) {
        context.pendingSubscriptionDataStore.edit { prefs ->
            if (subscription == null) {
                prefs.remove(PENDING_NAME)
                prefs.remove(PENDING_AMOUNT)
                prefs.remove(PENDING_DATE)
                prefs.remove(PENDING_CATEGORY)
            } else {
                prefs[PENDING_NAME] = subscription.name
                prefs[PENDING_AMOUNT] = subscription.averageAmount
                prefs[PENDING_DATE] = subscription.lastPaymentDate
                subscription.category?.let { prefs[PENDING_CATEGORY] = it }
                    ?: prefs.remove(PENDING_CATEGORY)
            }
        }
    }

    override suspend fun clearPending() {
        setPendingSubscription(null)
    }
}
