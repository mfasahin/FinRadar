package com.finradar.android.presentation.navigation

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.finradar.android.presentation.alerts.AlertsScreen
import com.finradar.android.presentation.dashboard.DashboardScreen
import com.finradar.android.presentation.onboarding.OnboardingScreen
import com.finradar.android.presentation.subscriptions.AddSubscriptionScreen
import com.finradar.android.presentation.subscriptions.SubscriptionsScreen
import com.finradar.android.ui.theme.*

data class BottomNavItem(
    val screen: Screen,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Dashboard, "Ana Sayfa", Icons.Default.Home),
    BottomNavItem(Screen.Subscriptions, "Abonelikler", Icons.Default.List),
    BottomNavItem(Screen.Alerts, "Uyarılar", Icons.Default.Notifications)
)

@Composable
fun FinRadarNavGraph(navController: NavHostController) {
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDest = navBackStackEntry?.destination
            val showBar = bottomNavItems.any { it.screen.route == currentDest?.route }
            if (showBar) {
                NavigationBar(
                    containerColor = Surface,
                    contentColor = Primary
                ) {
                    bottomNavItems.forEach { item ->
                        val selected = currentDest?.hierarchy?.any { it.route == item.screen.route } == true
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    item.icon,
                                    contentDescription = item.label,
                                    tint = if (selected) Primary else TextSecondary
                                )
                            },
                            label = {
                                Text(
                                    item.label,
                                    color = if (selected) Primary else TextSecondary
                                )
                            },
                            selected = selected,
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = SurfaceVariant,
                                selectedIconColor = Primary,
                                selectedTextColor = Primary,
                                unselectedIconColor = TextSecondary,
                                unselectedTextColor = TextSecondary
                            ),
                            onClick = {
                                navController.navigate(item.screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        },
        containerColor = Background
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Dashboard.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Onboarding.route) {
                OnboardingScreen(
                    onPermissionsGranted = {
                        val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
                        context.startActivity(intent)
                        navController.navigate(Screen.Dashboard.route) {
                            popUpTo(Screen.Onboarding.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(Screen.Dashboard.route) {
                DashboardScreen(
                    onNavigateToAlerts = {
                        navController.navigate(Screen.Alerts.route)
                    }
                )
            }
            composable(Screen.Subscriptions.route) {
                SubscriptionsScreen(
                    onNavigateToAdd = {
                        navController.navigate(Screen.AddSubscription.route)
                    }
                )
            }
            composable(Screen.Alerts.route) {
                AlertsScreen()
            }
            composable(Screen.AddSubscription.route) {
                AddSubscriptionScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
