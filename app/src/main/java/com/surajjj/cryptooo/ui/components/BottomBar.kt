package com.surajjj.cryptooo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.surajjj.cryptooo.R
import com.surajjj.cryptooo.ui.navigation.BottomNavItem

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Analytics,
        BottomNavItem.Exchange,
        BottomNavItem.Record,
        BottomNavItem.Wallet
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Row(
        modifier = Modifier
            .width(290.dp)
            .shadow(elevation = 100.dp,
                shape = RoundedCornerShape(50),
                clip = false
            )
            .clip(RoundedCornerShape(50))
            .background(color = colorResource(R.color.black))
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(if (isSelected) Color(0xFF1014B4) else Color.Transparent)
                    .clickable {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(item.icon),
                    contentDescription = item.label,
                    tint = if (isSelected) colorResource(R.color.white) else colorResource(R.color.white),
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = item.label,
                    color = if (isSelected) colorResource(R.color.white) else colorResource(R.color.white),
                    fontSize = MaterialTheme.typography.labelSmall.fontSize
                )
            }
        }
    }
}