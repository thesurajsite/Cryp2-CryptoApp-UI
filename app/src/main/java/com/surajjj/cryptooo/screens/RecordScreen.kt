package com.surajjj.cryptooo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajjj.cryptooo.R
import com.surajjj.cryptooo.data.model.Transactions

@Composable
fun RecordScreen() {

    val itemList = listOf(
        Transactions(R.drawable.receive, "Received", "20 March", "BTC", "+0.002126"),
        Transactions(R.drawable.send, "Sent", "19 March", "ETH", "+0.003126"),
        Transactions(R.drawable.send, "Sent", "18 March", "LTC", "+0.02126"),
        Transactions(R.drawable.receive, "Received", "20 March", "BTC", "+0.002126"),
        Transactions(R.drawable.send, "Sent", "19 March", "ETH", "+0.003126"),
        Transactions(R.drawable.send, "Sent", "18 March", "LTC", "+0.02126"),
        Transactions(R.drawable.receive, "Received", "20 March", "BTC", "+0.002126"),
        Transactions(R.drawable.send, "Sent", "19 March", "ETH", "+0.003126"),
        Transactions(R.drawable.send, "Sent", "18 March", "LTC", "+0.02126"),
        Transactions(R.drawable.receive, "Received", "20 March", "BTC", "+0.002126"),
        Transactions(R.drawable.send, "Sent", "19 March", "ETH", "+0.003126"),
        Transactions(R.drawable.send, "Sent", "18 March", "LTC", "+0.02126"),
        Transactions(R.drawable.receive, "Received", "20 March", "BTC", "+0.002126"),
        Transactions(R.drawable.send, "Sent", "19 March", "ETH", "+0.003126"),
        Transactions(R.drawable.send, "Sent", "18 March", "LTC", "+0.02126"),
        Transactions(R.drawable.receive, "Received", "20 March", "BTC", "+0.002126"),
        Transactions(R.drawable.send, "Sent", "19 March", "ETH", "+0.003126"),
        Transactions(R.drawable.send, "Sent", "18 March", "LTC", "+0.02126"),
    )


    Text("Analytics Screen")

    Scaffold(modifier = Modifier.fillMaxSize().padding()) { padding ->

        Box(modifier = Modifier.fillMaxSize().padding(padding).background(Color.Black)
        ){

            // Gradient Bottom
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

            Column(modifier = Modifier.fillMaxSize()
                .padding(start = 18.dp, end = 18.dp, top = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally)
            {

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Image(
                        painter = painterResource(R.drawable.hamburger),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.bell),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )

                }

                Spacer(Modifier.height(20.dp))

                Box(modifier = Modifier.fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF847AFF),
                                Color(0xFF1c2450)
                            ),
                            start = Offset.Zero,
                            end = Offset.Infinite
                        )
                    )
                ){
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Box(modifier = Modifier.width(50.dp).height(40.dp)
                            .height(180.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(Color(0xFF282ab4)),
                            contentAlignment = Alignment.Center
                        ){
                            Text("INR", color = Color.White, fontWeight = FontWeight.Bold)
                        }

                        Spacer(Modifier.height(10.dp))

                        Text("1,57,342.05", fontSize = 35.sp, color = Color.White)

                        Spacer(Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically)
                        {
                            Text("₹ 1,342", fontSize = 15.sp, color = Color.White)
                            Spacer(modifier = Modifier.width(20.dp))
                            Text("+4.6%", fontSize = 15.sp, color = Color.Green)
                        }
                    }
                }

                Spacer(Modifier.height(20.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center)
                {
                    Image(
                        painter = painterResource(R.drawable.up),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )

                    Spacer(Modifier.width(12.dp))

                    Image(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )

                    Spacer(Modifier.width(12.dp))

                    Image(
                        painter = painterResource(R.drawable.down),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }

                Spacer(Modifier.height(30.dp))

                // Transactions Row
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Transactions", fontSize = 14.sp, color = Color(0xFF727272))
                    Spacer(Modifier.weight(1f))
                    Text("Last 4 days", fontSize = 14.sp, color = Color.White)
                }

                Spacer(Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    itemList.forEach { item ->

                        Spacer(Modifier.height(10.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFF151515))
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(item.image),
                                modifier = Modifier.size(40.dp),
                                contentDescription = ""
                            )

                            Spacer(Modifier.width(10.dp))

                            Column(Modifier.wrapContentSize()) {
                                Text(item.type, color = Color.White, fontSize = 16.sp)
                                Spacer(Modifier.height(5.dp))
                                Text(item.date, color = Color(0xFF727272), fontSize = 16.sp)
                            }

                            Spacer(Modifier.weight(1f))

                            Column(
                                Modifier.wrapContentSize(),
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(item.coin, color = Color.White, fontSize = 16.sp)
                                Spacer(Modifier.height(5.dp))
                                Text(item.amount, color = Color(0xFF727272), fontSize = 16.sp)
                            }
                        }
                    }

                    Spacer(Modifier.height(80.dp))
                }




            }










        }

    }
}