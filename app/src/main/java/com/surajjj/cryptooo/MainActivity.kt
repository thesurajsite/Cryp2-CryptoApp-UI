package com.surajjj.cryptooo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.surajjj.cryptooo.ui.components.BottomBar
import com.surajjj.cryptooo.ui.navigation.NavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MyApp()
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    Box(
                        modifier = Modifier.padding(
                            start = 10.dp,
                            bottom = 24.dp
                        )
                    ) {
                        BottomBar(navController)
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {

                        },
                        shape = CircleShape,
                        modifier = Modifier.size(55.dp),
                        containerColor = colorResource(R.color.white)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    }
                },
                floatingActionButtonPosition = FabPosition.EndOverlay,
                modifier = Modifier.fillMaxSize()
                    .background(colorResource(R.color.black))
            ) { innerPadding ->
                NavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
            }
        }
    }
}



@Composable
fun MyApp() {
    val systemUiController = rememberSystemUiController()
    val navBarColor = Color(0xFF080B46)
    val statusBarColor = colorResource(R.color.black)

    SideEffect {
        systemUiController.setNavigationBarColor(
            color = navBarColor,
            darkIcons = false
        )

        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
    }
}

