package com.surajjj.cryptooo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.surajjj.cryptooo.screens.AnalyticsScreen
import com.surajjj.cryptooo.screens.ExchangeScreen
import com.surajjj.cryptooo.screens.RecordScreen
import com.surajjj.cryptooo.screens.WalletScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Analytics.route) {
        composable(BottomNavItem.Analytics.route) { AnalyticsScreen() }
        composable(BottomNavItem.Exchange.route) { ExchangeScreen(navController) }
        composable(BottomNavItem.Record.route) { RecordScreen() }
        composable(BottomNavItem.Wallet.route) { WalletScreen() }
    }
}