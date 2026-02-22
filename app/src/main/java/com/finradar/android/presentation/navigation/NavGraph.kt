package com.finradar.android.presentation.navigation

import android.content.Intent
import android.provider.Settings
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
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
import com.finradar.android.presentation.alerts.AlertsScreen
import com.finradar.android.presentation.dashboard.DashboardScreen
import com.finradar.android.presentation.onboarding.OnboardingScreen
import com.finradar.android.presentation.settings.SettingsScreen
import com.finradar.android.presentation.subscriptions.AddSubscriptionScreen
import com.finradar.android.presentation.subscriptions.SubscriptionsScreen
import com.finradar.android.ui.theme.*

data class BottomNavItem(
    val screen: Screen,
    val label: String,
    val icon: ImageVector,
    val activeIcon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Dashboard,     "Ana Sayfa",   Icons.Outlined.Home,          Icons.Filled.Home),
    BottomNavItem(Screen.Subscriptions, "Abonelikler", Icons.Outlined.List,          Icons.Filled.List),
    BottomNavItem(Screen.Alerts,        "Uyarılar",    Icons.Outlined.Notifications, Icons.Filled.Notifications),
    BottomNavItem(Screen.Settings,      "Ayarlar",     Icons.Outlined.Settings,      Icons.Filled.Settings)
)

@Composable
fun FinRadarNavGraph(navController: NavHostController) {
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDest = navBackStackEntry?.destination
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
                            onClick = {
                                navController.navigate(item.screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    if (selected) item.activeIcon else item.icon,
                                    contentDescription = item.label,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            label = {
                                Text(
                                    item.label,
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
            startDestination = Screen.Dashboard.route,
            modifier         = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Onboarding.route) {
                OnboardingScreen(
                    onPermissionsGranted = {
                        context.startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
                        navController.navigate(Screen.Dashboard.route) {
                            popUpTo(Screen.Onboarding.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Dashboard.route) {
                DashboardScreen(onNavigateToAlerts = { navController.navigate(Screen.Alerts.route) })
            }

            composable(Screen.Subscriptions.route) {
                SubscriptionsScreen(
                    onNavigateToAdd  = { navController.navigate(Screen.AddSubscription.route) },
                    onNavigateToEdit = { id -> navController.navigate(Screen.EditSubscription.createRoute(id)) }
                )
            }

            composable(Screen.Alerts.route)   { AlertsScreen() }
            composable(Screen.Settings.route) { SettingsScreen() }

            // Add
            composable(Screen.AddSubscription.route) {
                AddSubscriptionScreen(subscriptionId = null, onNavigateBack = { navController.popBackStack() })
            }

            // Edit
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
