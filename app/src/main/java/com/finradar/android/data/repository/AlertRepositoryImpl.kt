package com.finradar.android.data.repository

import com.finradar.android.data.local.dao.AlertDao
import com.finradar.android.data.local.entity.AlertEntity
import com.finradar.android.domain.model.Alert
import com.finradar.android.domain.model.AlertType
import com.finradar.android.domain.repository.AlertRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AlertRepositoryImpl @Inject constructor(
    private val dao: AlertDao
) : AlertRepository {

    override suspend fun saveAlert(alert: Alert): Long {
        val entity = AlertEntity(
            subscriptionId   = alert.subscriptionId,
            subscriptionName = alert.subscriptionName,
            oldAmount        = alert.oldAmount,
            newAmount        = alert.newAmount,
            percentageChange = alert.percentageChange,
            isRead           = alert.isRead,
            date             = alert.date,
            type             = alert.type.name
        )
        return dao.insertAlert(entity)
    }

    override fun getAllAlerts(): Flow<List<Alert>> {
        return dao.getAllAlerts().map { entities ->
            entities.map { entity ->
                Alert(
                    id               = entity.id,
                    subscriptionId   = entity.subscriptionId,
                    subscriptionName = entity.subscriptionName,
                    oldAmount        = entity.oldAmount,
                    newAmount        = entity.newAmount,
                    percentageChange = entity.percentageChange,
                    isRead           = entity.isRead,
                    date             = entity.date,
                    type             = runCatching { AlertType.valueOf(entity.type) }.getOrDefault(AlertType.PRICE_CHANGE)
                )
            }
        }
    }

    override fun getUnreadAlertCount(): Flow<Int> {
        return dao.getUnreadAlertCount()
    }
}
