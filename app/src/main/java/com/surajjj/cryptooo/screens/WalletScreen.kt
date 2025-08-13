package com.surajjj.cryptooo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun WalletScreen() {
    Text("Analytics Screen")

    Scaffold(modifier = Modifier.fillMaxSize().padding()) { padding ->

        Box(modifier = Modifier.fillMaxSize().padding(padding).background(Color.Black)
        ){

            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text("Wallet Screen", color = Color.White, fontSize =24.sp)

            }




            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.20f)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF1014B4).copy(alpha = 0.4f),
                                Color.Black
                            ),
                            startY = Float.POSITIVE_INFINITY,
                            endY = 0f
                        ),

                        )
            )

        }

    }
}