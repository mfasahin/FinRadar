package com.finradar.android.presentation.navigation

sealed class Screen(val route: String) {
    object Onboarding     : Screen("onboarding")
    object Dashboard      : Screen("dashboard")
    object Subscriptions  : Screen("subscriptions")
    object Alerts         : Screen("alerts")
    object AddSubscription: Screen("add_subscription")
    // Edit: route includes optional subscriptionId argument
    object EditSubscription : Screen("edit_subscription/{subscriptionId}") {
        fun createRoute(id: Long) = "edit_subscription/$id"
    }
}
