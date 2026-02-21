package com.finradar.android.presentation.navigation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Dashboard : Screen("dashboard")
    object Subscriptions : Screen("subscriptions")
    object Alerts : Screen("alerts")
    object AddSubscription : Screen("add_subscription")
}
