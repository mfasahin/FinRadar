package com.finradar.android.presentation.navigation

import android.content.Intent
import android.provider.Settings
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.finradar.android.R
import com.finradar.android.presentation.alerts.AlertsScreen
import com.finradar.android.presentation.dashboard.DashboardScreen
import com.finradar.android.presentation.onboarding.OnboardingScreen
import com.finradar.android.presentation.settings.PrivacyPolicyScreen
import com.finradar.android.presentation.settings.SettingsScreen
import com.finradar.android.presentation.settings.SettingsViewModel
import com.finradar.android.presentation.subscriptions.AddSubscriptionScreen
import com.finradar.android.presentation.subscriptions.SubscriptionsScreen
import com.finradar.android.ui.theme.*
import androidx.hilt.navigation.compose.hiltViewModel

data class BottomNavItem(
    val screen: Screen,
    @StringRes val labelRes: Int,
    val icon: ImageVector,
    val activeIcon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Dashboard,     R.string.nav_home,          Icons.Outlined.Home,          Icons.Filled.Home),
    BottomNavItem(Screen.Subscriptions, R.string.nav_subscriptions, Icons.Outlined.List,          Icons.Filled.List),
    BottomNavItem(Screen.Alerts,        R.string.nav_alerts,        Icons.Outlined.Notifications, Icons.Filled.Notifications),
    BottomNavItem(Screen.Settings,      R.string.nav_settings,      Icons.Outlined.Settings,      Icons.Filled.Settings)
)

@Composable
fun FinRadarNavGraph(
    navController: NavHostController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDest = navBackStackEntry?.destination
    
    val onboardingCompleted by viewModel.isOnboardingCompleted.collectAsState()
    val startDest = if (onboardingCompleted) Screen.Dashboard.route else Screen.Onboarding.route

    // Helper to navigate to bottom tabs consistently
    val navigateToTab: (String) -> Unit = { route ->
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    val showBar = bottomNavItems.any { it.screen.route == currentDest?.route }

    Scaffold(
        containerColor = BgDeep,
        bottomBar = {
            if (showBar) {
                NavigationBar(
                    containerColor = BgDeep,
                    tonalElevation = 0.dp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(BgDeep)
                ) {
                    bottomNavItems.forEach { item ->
                        val selected = currentDest?.hierarchy?.any { it.route == item.screen.route } == true
                        NavigationBarItem(
                            selected = selected,
                            onClick = { navigateToTab(item.screen.route) },
                            icon = {
                                Icon(
                                    if (selected) item.activeIcon else item.icon,
                                    contentDescription = stringResource(item.labelRes),
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            label = {
                                Text(
                                    stringResource(item.labelRes),          // ← localized
                                    fontSize = 11.sp,
                                    fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor   = BrandFrom,
                                selectedTextColor   = BrandFrom,
                                unselectedIconColor = TextMed,
                                unselectedTextColor = TextMed,
                                indicatorColor      = BrandFrom.copy(alpha = 0.12f)
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController    = navController,
            startDestination = startDest,
            modifier         = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Onboarding.route) {
                OnboardingScreen(
                    onPermissionsGranted = {
                        viewModel.setOnboardingCompleted()
                        context.startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
                        navController.navigate(Screen.Dashboard.route) {
                            popUpTo(Screen.Onboarding.route) { inclusive = true }
                        }
                    },
                    onNavigateToPrivacy = { navController.navigate(Screen.PrivacyPolicy.route) }
                )
            }
            composable(Screen.Dashboard.route) {
                DashboardScreen(onNavigateToAlerts = { navigateToTab(Screen.Alerts.route) })
            }
            composable(Screen.Subscriptions.route) {
                SubscriptionsScreen(
                    onNavigateToAdd  = { navController.navigate(Screen.AddSubscription.route) },
                    onNavigateToEdit = { id -> navController.navigate(Screen.EditSubscription.createRoute(id)) }
                )
            }
            composable(Screen.Alerts.route)   { AlertsScreen() }
            composable(Screen.Settings.route) { 
                SettingsScreen(onNavigateToPrivacy = { navController.navigate(Screen.PrivacyPolicy.route) }) 
            }
            composable(Screen.PrivacyPolicy.route) {
                PrivacyPolicyScreen(onNavigateBack = { navController.popBackStack() })
            }
            composable(Screen.AddSubscription.route) {
                AddSubscriptionScreen(subscriptionId = null, onNavigateBack = { navController.popBackStack() })
            }
            composable(
                route     = Screen.EditSubscription.route,
                arguments = listOf(navArgument("subscriptionId") { type = NavType.LongType })
            ) { backStackEntry ->
                AddSubscriptionScreen(
                    subscriptionId = backStackEntry.arguments?.getLong("subscriptionId"),
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
