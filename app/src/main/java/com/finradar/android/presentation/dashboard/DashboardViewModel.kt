package com.finradar.android.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finradar.android.domain.model.Subscription
import com.finradar.android.domain.repository.AlertRepository
import com.finradar.android.domain.repository.SubscriptionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class DashboardUiState(
    val totalMonthlySpend: Double = 0.0,
    val totalActiveCount: Int = 0,
    val topSubscriptions: List<Subscription> = emptyList(),
    val upcomingPayments: List<Subscription> = emptyList(),
    val unreadAlertCount: Int = 0
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    subscriptionRepository: SubscriptionRepository,
    alertRepository: AlertRepository
) : ViewModel() {

    val uiState: StateFlow<DashboardUiState> = combine(
        subscriptionRepository.getActiveSubscriptions(),
        alertRepository.getUnreadAlertCount()
    ) { subscriptions, alertCount ->
        DashboardUiState(
            totalMonthlySpend  = subscriptions.sumOf { it.averageAmount },
            totalActiveCount   = subscriptions.size,
            topSubscriptions   = subscriptions.sortedByDescending { it.averageAmount }.take(3),
            upcomingPayments   = subscriptions
                .filter { it.nextPaymentDate > 0 }
                .sortedBy { it.nextPaymentDate }
                .take(5),
            unreadAlertCount   = alertCount
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DashboardUiState()
    )
}
