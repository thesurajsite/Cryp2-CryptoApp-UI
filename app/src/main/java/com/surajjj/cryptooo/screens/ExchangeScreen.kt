package com.surajjj.cryptooo.screens

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.surajjj.cryptooo.ui.navigation.BottomNavItem
import com.surajjj.cryptooo.R

@Composable
fun ExchangeScreen(navController: NavController) {
    Text("Analytics Screen")

    Scaffold(modifier = Modifier.fillMaxSize().padding()) { padding ->

        Box(modifier = Modifier.fillMaxSize().padding(padding).background(Color.Black)
        ){


            Column(modifier = Modifier.fillMaxSize().padding(start = 16.dp, top = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start)
            {

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Image(
                        painter = painterResource(R.drawable.left_arrow),
                        contentDescription = "",
                        modifier = Modifier.size(40.dp)
                            .clickable{
                                navController.navigate(BottomNavItem.Analytics.route)
                            }
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Text("Exchange", fontSize = 20.sp, color = Color.White)

                }

                Spacer(modifier = Modifier.height(18.dp))

                Box(modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center) {


                    Column(modifier = Modifier.fillMaxWidth()) {
                        UpperBox()
                        Spacer(modifier = Modifier.height(12.dp))
                        LowerBox()
                    }

                    Image(painter = painterResource(R.drawable.up_down_arrow),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }

                Spacer(Modifier.height(20.dp))

                // Exchange Button
                Button(modifier = Modifier.fillMaxWidth()
                    .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1e4ddb)
                    ),
                    onClick = {

                    }) {
                    Text("Exchange", color = Color.White, fontSize = 18.sp)
                }

                Spacer(Modifier.height(30.dp))


                // Rate Row
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Rate", fontSize = 14.sp, color = Color(0xFF727272))

                    Spacer(Modifier.weight(1f))

                    Text("1 ETH = ₹ 1,76,138.80", fontSize = 14.sp, color = Color.White)

                }

                Spacer(Modifier.height(10.dp))

                // Spread Row
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Spread", fontSize = 14.sp, color = Color(0xFF727272))

                    Spacer(Modifier.weight(1f))

                    Text("0.2%", fontSize = 14.sp, color = Color.White)

                }

                Spacer(Modifier.height(10.dp))

                // Gas Fee Row
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Gas fee", fontSize = 14.sp, color = Color(0xFF727272))

                    Spacer(Modifier.weight(1f))

                    Text("₹ 422.73", fontSize = 14.sp, color = Color.White)

                }

                Spacer(Modifier.height(10.dp))

                // you will receive Row
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("You will recieve", fontSize = 14.sp, color = Color(0xFF727272))

                    Spacer(Modifier.weight(1f))

                    Text("₹ 1,75,716.07", fontSize = 14.sp, color = Color.White)

                }

                Spacer(Modifier.height(10.dp))

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
                        )
                    )
            )

        }

    }
}

@Composable
fun UpperBox(){

    Box(modifier = Modifier.fillMaxWidth()
        .height(180.dp)
        .clip(shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
        .background(Color(0xFF151517))
    ){
        Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp, start = 12.dp, end = 24.dp)) {

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {


                Image(painter = painterResource(R.drawable.etherium),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )

                Spacer(Modifier.width(12.dp))

                Text("ETH", fontSize = 20.sp, color = Color.White)

                Image(painter = painterResource(R.drawable.left_arrow),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp).rotate(270f)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text("Send", fontSize = 14.sp, color = Color.White)

            }

            Spacer(Modifier.weight(1f))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("2.640", fontSize = 35.sp, color = Color.White)

            }

            Spacer(Modifier.weight(1f))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Balance", fontSize = 16.sp, color = Color(0xFF727272))

                Spacer(Modifier.weight(1f))

                Text("10.254", fontSize = 16.sp, color = Color(0xFF727272))

            }
        }


    }
}


@Composable
fun LowerBox(){

    Box(modifier = Modifier.fillMaxWidth()
        .height(180.dp)
        .clip(shape = RoundedCornerShape(bottomStart = 18.dp, bottomEnd = 18.dp))
        .background(Color(0xFF151517))
    ){

        Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, bottom = 16.dp, start = 12.dp, end = 24.dp)) {

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {


                Image(painter = painterResource(R.drawable.rupee),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )

                Spacer(Modifier.width(12.dp))

                Text("INR", fontSize = 20.sp, color = Color.White)

                Image(painter = painterResource(R.drawable.left_arrow),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp).rotate(270f)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text("Receive", fontSize = 14.sp, color = Color.White)

            }

            Spacer(Modifier.weight(1f))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("₹ 4,65,006.44", fontSize = 35.sp, color = Color.White)

            }

            Spacer(Modifier.weight(1f))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Balance", fontSize = 16.sp, color = Color(0xFF727272))

                Spacer(Modifier.weight(1f))

                Text("4,35,804", fontSize = 16.sp, color = Color(0xFF727272))

            }
        }


    }
}