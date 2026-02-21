package com.finradar.android.presentation.alerts

import androidx.lifecycle.ViewModel
import com.finradar.android.domain.model.Alert
import com.finradar.android.domain.repository.AlertRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AlertsViewModel @Inject constructor(
    alertRepository: AlertRepository
) : ViewModel() {
    val alerts: Flow<List<Alert>> = alertRepository.getAllAlerts()
}
