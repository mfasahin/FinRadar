package com.finradar.android.presentation.alerts;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.font.FontWeight;
import com.finradar.android.R;
import com.finradar.android.domain.model.Alert;
import com.finradar.android.domain.model.AlertType;
import com.finradar.android.ui.theme.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0012\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001e\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u001e\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u000b"}, d2 = {"AlertItemWrapper", "", "alert", "Lcom/finradar/android/domain/model/Alert;", "onDelete", "Lkotlin/Function0;", "AlertsScreen", "viewModel", "Lcom/finradar/android/presentation/alerts/AlertsViewModel;", "PriceChangeAlertCard", "ReminderAlertCard", "app_debug"})
public final class AlertsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AlertsScreen(@org.jetbrains.annotations.NotNull()
    com.finradar.android.presentation.alerts.AlertsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AlertItemWrapper(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Alert alert, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PriceChangeAlertCard(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Alert alert, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ReminderAlertCard(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Alert alert, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
}