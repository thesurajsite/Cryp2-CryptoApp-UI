package com.surajjj.cryptooo.ui.navigation

import com.surajjj.cryptooo.R

sealed class BottomNavItem(val route: String, val label: String, val icon: Int) {
    object Analytics : BottomNavItem("analytics", "Analytics", R.drawable.analytic)
    object Exchange : BottomNavItem("exchange", "Exchange", R.drawable.exchange)
    object Record : BottomNavItem("record", "Record", R.drawable.record)
    object Wallet : BottomNavItem("wallet", "Wallet", R.drawable.wallet)
}