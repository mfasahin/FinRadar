package com.finradar.android.domain.repository

import com.finradar.android.domain.model.Alert
import kotlinx.coroutines.flow.Flow

interface AlertRepository {
    suspend fun saveAlert(alert: Alert): Long
    fun getAllAlerts(): Flow<List<Alert>>
    fun getUnreadAlertCount(): Flow<Int>
}
