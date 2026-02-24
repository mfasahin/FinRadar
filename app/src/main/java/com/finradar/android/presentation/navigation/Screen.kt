package com.finradar.android.presentation.navigation

sealed class Screen(val route: String) {
    object Onboarding       : Screen("onboarding")
    object Dashboard        : Screen("dashboard")
    object Subscriptions    : Screen("subscriptions")
    object Alerts           : Screen("alerts")
    object Settings         : Screen("settings")
    object AddSubscription  : Screen("add_subscription")
    object PrivacyPolicy     : Screen("privacy_policy")
    object EditSubscription : Screen("edit_subscription/{subscriptionId}") {
        fun createRoute(id: Long) = "edit_subscription/$id"
    }
}
