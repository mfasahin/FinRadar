package com.finradar.android.presentation.pending

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.repository.PendingSubscriptionRepository
import com.finradar.android.domain.repository.SubscriptionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PendingSubscriptionViewModel @Inject constructor(
    private val pendingSubscriptionRepository: PendingSubscriptionRepository,
    private val subscriptionRepository: SubscriptionRepository
) : ViewModel() {

    val pendingSubscription: StateFlow<Subscription?> = pendingSubscriptionRepository.getPendingSubscription()
        .stateIn(viewModelScope, SharingStarted.Eagerly, null)

    fun confirmSave() {
        viewModelScope.launch {
            val pending = pendingSubscription.value ?: return@launch
            subscriptionRepository.saveSubscription(pending)
            pendingSubscriptionRepository.clearPending()
        }
    }

    fun dismiss() {
        viewModelScope.launch {
            pendingSubscriptionRepository.clearPending()
        }
    }
}
