package com.finradar.android.presentation.dashboard;

import androidx.compose.animation.core.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.finradar.android.R;
import com.finradar.android.domain.model.Subscription;
import com.finradar.android.ui.theme.*;
import java.text.NumberFormat;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\"\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\b0\b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001a"}, d2 = {"DashboardScreen", "", "onNavigateToAlerts", "Lkotlin/Function0;", "viewModel", "Lcom/finradar/android/presentation/dashboard/DashboardViewModel;", "EmptyState", "message", "", "HeroCard", "totalSpend", "", "activeCount", "", "PremiumSubscriptionRow", "subscription", "Lcom/finradar/android/domain/model/Subscription;", "StatChip", "label", "color", "Landroidx/compose/ui/graphics/Color;", "StatChip-4WTKRHQ", "(Ljava/lang/String;J)V", "formatAmount", "kotlin.jvm.PlatformType", "amount", "app_debug"})
public final class DashboardScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DashboardScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAlerts, @org.jetbrains.annotations.NotNull()
    com.finradar.android.presentation.dashboard.DashboardViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void HeroCard(double totalSpend, int activeCount) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PremiumSubscriptionRow(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.model.Subscription subscription) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyState(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    private static final java.lang.String formatAmount(double amount) {
        return null;
    }
}