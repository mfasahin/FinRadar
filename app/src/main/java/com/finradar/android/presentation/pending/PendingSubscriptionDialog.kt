package com.finradar.android.presentation.pending

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.finradar.android.R
import com.finradar.android.domain.model.Subscription

@Composable
fun PendingSubscriptionDialog(
    subscription: Subscription?,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (subscription == null) return

    val amountStr = String.format("%.2f", subscription.averageAmount)
    val message = stringResource(R.string.pending_sub_message, subscription.name, amountStr)

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.pending_sub_title)) },
        text = { Text(message) },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(stringResource(R.string.pending_sub_save), color = MaterialTheme.colorScheme.primary)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.pending_sub_dismiss), color = MaterialTheme.colorScheme.onSurface)
            }
        }
    )
}
