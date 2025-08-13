package com.surajjj.cryptooo.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajjj.cryptooo.R
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.surajjj.cryptooo.data.model.Transactions


@Composable
fun AnalyticsScreen() {

    var isMoneySelected by remember { mutableStateOf(true) }

    val itemList = listOf(
        Transactions(R.drawable.bitcoin_icon, "Received", "20 March", "BTC", "+0.002126"),
        Transactions(R.drawable.etherium_icon, "Sent", "19 March", "ETH", "+0.003126"),
        Transactions(R.drawable.bitcoin_icon, "Sent", "18 March", "LTC", "+0.02126"),
        Transactions(R.drawable.etherium_icon, "Received", "20 March", "BTC", "+0.002126"),
    )

    Scaffold(modifier = Modifier.fillMaxSize().padding()) { padding ->

        Box(modifier = Modifier.fillMaxSize().padding(padding).background(Color.Black)
        ){
            // Bottom Gradient
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

            Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // BOX
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                        .drawWithCache {
                            val gradient = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xAA000000),
                                    Color(0xFF847AFF)
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(0f, size.height)
                            )
                            onDrawBehind {
                                drawRect(gradient)
                            }
                        }
                ) {

                    Column(modifier = Modifier.fillMaxSize()
                    ) {

                        Row(modifier = Modifier.fillMaxWidth()
                            .padding(start = 16.dp, top = 30.dp, end = 16.dp, bottom = 0.dp),
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

                        Spacer(Modifier.height(24.dp))

                        Row(modifier = Modifier.fillMaxWidth()
                            .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 0.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically)
                        {

                            Text("Portfolio Value", color = Color.White, fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(
                                painter = painterResource(R.drawable.left_arrow),
                                contentDescription = "",
                                modifier = Modifier.size(25.dp)
                            )

                            Spacer(modifier = Modifier.weight(1f))


                            IconToggle(
                                isFirstSelected = isMoneySelected,
                                firstIcon = R.drawable.money,
                                secondIcon = R.drawable.curr_bitcoin
                            ) {
                                isMoneySelected = !isMoneySelected
                            }
                        }

                        Spacer(Modifier.height(18.dp))

                        Text(
                            text = if (isMoneySelected) "₹ 1,57,342.05" else "₿ 0.01476",
                            fontSize = 35.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp),
                            fontWeight = FontWeight.Bold
                        )



                    }
                }

                // Scrollable column
                Column(modifier = Modifier.fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                ){
                    Spacer(Modifier.height(12.dp))

                    // Time Range Selector
                    TimeRangeSelector()

                    Image(painter = painterResource(R.drawable.chart), contentDescription = "", modifier = Modifier.padding(horizontal = 0.dp))

                    Spacer(Modifier.height(10.dp))

                    // Crypto Cards Lazy Row
                    CryptoLazyRow()

                    Spacer(Modifier.height(10.dp))

                    // Transactions Row
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Recent Transactions", fontSize = 16.sp, color = Color(0xFF727272))
                    }

                    // LazyColumn
                    itemList.forEach{ item->

                        Spacer(Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF151515))
                            .padding(10.dp)
                        ) {
                            Image(painter = painterResource(item.image), modifier = Modifier.size(40.dp), contentDescription = "")

                            Spacer(Modifier.width(10.dp))

                            Column(Modifier.wrapContentSize()) {
                                Text(item.type, color = Color.White, fontSize = 16.sp)
                                Spacer(Modifier.height(5.dp))
                                Text(item.date, color = Color(0xFF727272), fontSize = 16.sp)
                            }

                            Spacer(Modifier.weight(1f))

                            Column(Modifier.wrapContentSize(),
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
@Composable
fun IconToggle(
    isFirstSelected: Boolean,
    firstIcon: Int,
    secondIcon: Int,
    size: Dp = 40.dp,
    iconSize: Dp = size / 2,
    padding: Dp = 6.dp,
    onToggle: () -> Unit
) {
    val offset by animateDpAsState(
        targetValue = if (isFirstSelected) 0.dp else size,
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = Modifier
            .width(size * 2)
            .height(size)
            .clip(RoundedCornerShape(50))
            .clickable { onToggle() }
            .background(Color(0xFF1C1B20))
    ) {
        // Moving circle
        Box(
            modifier = Modifier
                .size(size)
                .offset(x = offset)
                .padding(all = padding)
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = if (isFirstSelected) firstIcon else secondIcon),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(iconSize)
            )
        }

        // Static icons
        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(size),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = firstIcon),
                    contentDescription = null,
                    tint = if (isFirstSelected) Color.White else Color.Gray,
                    modifier = Modifier.size(iconSize)
                )
            }
            Box(
                modifier = Modifier.size(size),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = secondIcon),
                    contentDescription = null,
                    tint = if (isFirstSelected) Color.Gray else Color.White,
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}


@Composable
fun TimeRangeSelector() {
    val items = listOf("1h", "8h", "1d", "1w", "1m", "6m", "1y")
    var selectedItem by remember { mutableStateOf("6m") }

    Row(
        modifier = Modifier
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items.forEach { label ->
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        if (selectedItem == label) Color.DarkGray else Color.Transparent
                    )
                    .clickable { selectedItem = label }
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = if (selectedItem == label) Color.White else Color.DarkGray
                )
            }
        }
    }
}


@Composable
fun CryptoCard(
    icon: Int,
    name: String,
    price: String,
    changePercent: String,
    changeColor: Color
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(Color(0xFF1C1C1E), RoundedCornerShape(16.dp))
            .padding(16.dp)
            .width(200.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = name,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = name,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = price,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = changePercent,
                    color = changeColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

data class Crypto(
    val name: String,
    val price: String,
    val changePercent: String,
    val icon: Int
)

@Composable
fun CryptoLazyRow() {
    val cryptos = listOf(
        Crypto( "Bitcoin (BTC)", "₹ 75,62,502.14", "+3.2%", R.drawable.bitcoin_icon,),
        Crypto("Ethereum (ETH)", "₹ 2,54,000.50", "-1.5%", R.drawable.etherium_icon),
        Crypto( "Bitcoin (BTC)", "₹ 75,62,502.14", "+3.2%", R.drawable.bitcoin_icon,),
        Crypto("Ethereum (ETH)", "₹ 2,54,000.50", "-1.5%", R.drawable.etherium_icon),
    )

    LazyRow {
        items(cryptos) { crypto ->
            CryptoCard(
                icon = crypto.icon,
                name = crypto.name,
                price = crypto.price,
                changePercent = crypto.changePercent,
                changeColor = if (crypto.changePercent.startsWith("+")) Color(0xFF4CAF50) else Color(0xFFF44336)
            )
        }
    }
}

