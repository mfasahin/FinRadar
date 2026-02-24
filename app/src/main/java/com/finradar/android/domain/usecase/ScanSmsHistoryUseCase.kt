package com.finradar.android.domain.usecase

import android.content.Context
import android.net.Uri
import android.provider.Telephony
import com.finradar.android.domain.repository.TransactionRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScanSmsHistoryUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val processIncomingSmsUseCase: ProcessIncomingSmsUseCase,
    private val transactionRepository: TransactionRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        val uri = Uri.parse("content://sms/inbox")
        val projection = arrayOf("_id", "address", "body", "date")
        
        // Scan last 30 days
        val thirtyDaysAgo = System.currentTimeMillis() - (30L * 24 * 60 * 60 * 1000)
        val selection = "date > ?"
        val selectionArgs = arrayOf(thirtyDaysAgo.toString())
        val sortOrder = "date DESC"

        context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)?.use { cursor ->
            val addressIndex = cursor.getColumnIndexOrThrow("address")
            val bodyIndex = cursor.getColumnIndexOrThrow("body")
            val dateIndex = cursor.getColumnIndexOrThrow("date")

            while (cursor.moveToNext()) {
                val address = cursor.getString(addressIndex) ?: ""
                val body = cursor.getString(bodyIndex) ?: ""
                val date = cursor.getLong(dateIndex)

                // De-duplication: check if this exact transaction already exists
                // Note: originalMessage is saved in TransactionEntity
                val exists = transactionRepository.isTransactionDuplicate(body, date)
                if (!exists) {
                    processIncomingSmsUseCase(address, body, date)
                }
            }
        }
    }
}
