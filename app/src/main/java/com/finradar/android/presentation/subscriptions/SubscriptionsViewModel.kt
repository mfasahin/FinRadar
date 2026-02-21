package com.finradar.android.presentation.subscriptions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.repository.SubscriptionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubscriptionsViewModel @Inject constructor(
    private val subscriptionRepository: SubscriptionRepository
) : ViewModel() {

    val subscriptions: StateFlow<List<Subscription>> = subscriptionRepository
        .getActiveSubscriptions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun addSubscription(
        name: String,
        amount: Double,
        category: String
    ) {
        viewModelScope.launch {
            val subscription = Subscription(
                name = name.trim(),
                averageAmount = amount,
                lastPaymentDate = System.currentTimeMillis(),
                category = category.ifBlank { "Genel" },
                isActive = true
            )
            subscriptionRepository.saveSubscription(subscription)
        }
    }
}
