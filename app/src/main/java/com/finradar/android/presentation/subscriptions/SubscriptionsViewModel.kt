package com.finradar.android.presentation.subscriptions

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
    private val subscriptionRepository: SubscriptionRepository,
    private val scanSmsHistoryUseCase: com.finradar.android.domain.usecase.ScanSmsHistoryUseCase
) : ViewModel() {

    val subscriptions: StateFlow<List<Subscription>> = subscriptionRepository
        .getActiveSubscriptions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    private val _editTarget = MutableStateFlow<Subscription?>(null)
    val editTarget: StateFlow<Subscription?> = _editTarget.asStateFlow()

    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.value = true
            try {
                scanSmsHistoryUseCase()
            } catch (e: Exception) {
                // Log error
            } finally {
                _isRefreshing.value = false
            }
        }
    }

    fun addSubscription(name: String, amount: Double, category: String, nextPaymentDate: Long) {
        viewModelScope.launch {
            // If user set a next payment date, derive last payment as 30 days prior
            val lastPay = if (nextPaymentDate > 0) {
                nextPaymentDate - java.util.concurrent.TimeUnit.DAYS.toMillis(30)
            } else {
                System.currentTimeMillis()
            }
            subscriptionRepository.saveSubscription(
                Subscription(
                    name            = name.trim(),
                    averageAmount   = amount,
                    lastPaymentDate = lastPay,
                    nextPaymentDate = nextPaymentDate,
                    category        = category.ifBlank { "general" },
                    isActive        = true
                )
            )
        }
    }

    fun loadForEdit(id: Long) {
        viewModelScope.launch {
            _editTarget.value = subscriptionRepository.getSubscriptionById(id)
        }
    }

    fun updateSubscription(id: Long, name: String, amount: Double, category: String, nextPaymentDate: Long) {
        viewModelScope.launch {
            // Preserve the original lastPaymentDate — only update fields the user actually changed
            val original = subscriptionRepository.getSubscriptionById(id)
            subscriptionRepository.updateSubscription(
                Subscription(
                    id              = id,
                    name            = name.trim(),
                    averageAmount   = amount,
                    lastPaymentDate = original?.lastPaymentDate ?: System.currentTimeMillis(),
                    nextPaymentDate = nextPaymentDate,
                    category        = category.ifBlank { "general" },
                    isActive        = true
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
