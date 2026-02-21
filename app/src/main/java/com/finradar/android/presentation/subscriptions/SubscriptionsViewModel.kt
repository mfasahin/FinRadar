package com.finradar.android.presentation.subscriptions

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.repository.SubscriptionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    // Subscription loaded for editing
    private val _editTarget = MutableStateFlow<Subscription?>(null)
    val editTarget: StateFlow<Subscription?> = _editTarget.asStateFlow()

    fun addSubscription(name: String, amount: Double, category: String) {
        viewModelScope.launch {
            subscriptionRepository.saveSubscription(
                Subscription(
                    name = name.trim(),
                    averageAmount = amount,
                    lastPaymentDate = System.currentTimeMillis(),
                    category = category.ifBlank { "Genel" },
                    isActive = true
                )
            )
        }
    }

    fun loadForEdit(id: Long) {
        viewModelScope.launch {
            _editTarget.value = subscriptionRepository.getSubscriptionById(id)
        }
    }

    fun updateSubscription(id: Long, name: String, amount: Double, category: String) {
        viewModelScope.launch {
            subscriptionRepository.updateSubscription(
                Subscription(
                    id = id,
                    name = name.trim(),
                    averageAmount = amount,
                    lastPaymentDate = System.currentTimeMillis(),
                    category = category.ifBlank { "Genel" },
                    isActive = true
                )
            )
            _editTarget.value = null
        }
    }

    fun deleteSubscription(id: Long) {
        viewModelScope.launch {
            subscriptionRepository.deleteSubscription(id)
        }
    }
}
