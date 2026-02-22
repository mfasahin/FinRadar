package com.finradar.android.presentation.alerts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finradar.android.domain.model.Alert
import com.finradar.android.domain.repository.AlertRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlertsViewModel @Inject constructor(
    private val alertRepository: AlertRepository
) : ViewModel() {
    val alerts: Flow<List<Alert>> = alertRepository.getAllAlerts()

    fun deleteAlert(id: Long) {
        viewModelScope.launch {
            alertRepository.deleteAlert(id)
        }
    }

    fun clearAllAlerts() {
        viewModelScope.launch {
            alertRepository.clearAllAlerts()
        }
    }
}
