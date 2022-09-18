/*
   Copyright 2022 cyph3rcod3r

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.cyberwalker.nftmarketplace.ui

import android.graphics.BlurMaskFilter
import android.graphics.Paint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cyberwalker.nftmarketplace.R
import com.cyberwalker.nftmarketplace.ui.theme.*

@Composable
fun HomeScreen(scaffoldState: ScaffoldState = rememberScaffoldState()) {
    Scaffold(modifier = Modifier.padding(start = 24.dp, top = 24.dp),
        scaffoldState = scaffoldState,
        bottomBar = {
            NavBar()
        },
        topBar = {
            Row(modifier = Modifier.defaultMinSize(minHeight = 48.dp)) {
                Icon(
                    modifier = Modifier.clickable { },
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(1F))
                Icon(
                    modifier = Modifier.clickable { },
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(16.dp))
                Image(
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .size(24.dp)
                        .clickable { },
                    painter = painterResource(id = R.drawable.img_profile_new),
                    contentDescription = null
                )
            }
        }
    ) {
        Content(modifier = Modifier.padding(it))
    }
}

@Composable
private fun Content(modifier: Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.size(24.dp))
        TitleBar()
        Spacer(modifier = Modifier.size(24.dp))
        ListProduct()
        Spacer(modifier = Modifier.size(24.dp))
        Row(
            modifier = Modifier
                .padding(end = 24.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Featured Creator", style = MaterialTheme.typography.header)
            Icon(
                painter = painterResource(id = R.drawable.icon_next),
                contentDescription = null,
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        FollowerCard(1)
        Spacer(modifier = Modifier.size(16.dp))
        FollowerCard(2)
        Spacer(modifier = Modifier.size(16.dp))
        FollowerCard(1)
        Spacer(modifier = Modifier.size(16.dp))
        FollowerCard(2)
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Composable
fun ListProduct() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
        items(3) {
            ListItem()
        }
    }
}

@Composable
fun FollowerCard(i: Int, padding: Dp = 24.dp) {
    Row(
        modifier = Modifier
            .padding(end = padding)
            .fillMaxWidth()
            .background(followerBg, shape = RoundedCornerShape(16.dp))
            .defaultMinSize(minHeight = 88.dp)
            .padding(16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                id = if (i == 1) R.drawable.img_follow_1
                else R.drawable.img_follow_2
            ), contentDescription = null
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(
                text = if (i == 1) "Hemant Bisht" else "Vikas Soni",
                style = MaterialTheme.typography.buttonText
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = if (i == 1) "797 Followers" else "831 Followers",
                style = MaterialTheme.typography.small
            )
        }
        Spacer(modifier = Modifier.weight(1F))
        Button(
            onClick = { },
            modifier = Modifier
                .defaultMinSize(minHeight = 30.dp, minWidth = 90.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Follow", style = MaterialTheme.typography.small_bold)
        }
    }
}

@Composable
private fun BlurBox(modifier: Modifier, alpha: Float = 0.2F, color: Color = Teal200) {
    val paint by remember {
        val value = Paint()
        value.maskFilter = BlurMaskFilter(12F, BlurMaskFilter.Blur.NORMAL)
        value.color = color.copy(alpha = alpha).toArgb()
        mutableStateOf(value)
    }

    Canvas(
        modifier = modifier
    ) {
        val width = size.width
        val height = size.height

        drawIntoCanvas {
            it.nativeCanvas.drawRect(0F, 0F, width, height, paint)
        }
    }
}

@Composable
private fun TitleBar() {
    val modifier = Modifier
        .fillMaxWidth()
        .defaultMinSize(minWidth = 370.dp, minHeight = 40.dp)
        .border(shape = RoundedCornerShape(12.dp), width = 1.dp, color = OffWhite)
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = modifier
                .background(color = titlebg, shape = RoundedCornerShape(12.dp))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minWidth = 370.dp, minHeight = 40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                BlurBox(
                    Modifier
                        .offset(y = (-12).dp)
                        .size(70.dp, 12.dp), alpha = 0.5F
                )
                Spacer(
                    modifier = Modifier
                        .offset(y = (-16).dp)
                        .size(70.dp, 4.dp)
                        .background(color = Teal200, shape = RoundedCornerShape(16.dp))
                )
                Text(text = "Live Auction", style = MaterialTheme.typography.small_bold)
            }
            Text(text = "New", style = MaterialTheme.typography.small)
            Text(text = "Trending", style = MaterialTheme.typography.small)
            Text(text = "Top Created", style = MaterialTheme.typography.small)
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun ListItem() {
    Box(
        modifier = Modifier
            .defaultMinSize(minWidth = 264.dp, minHeight = 303.dp)
            .border(1.dp, OffWhite, RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_product),
            contentDescription = null,
            modifier = Modifier.align(
                Alignment.Center
            )
        )

        Image(
            painter = painterResource(id = R.drawable.ic_profile_other),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .align(
                    Alignment.TopStart
                )
                .size(32.dp)
        )

        Box(
            modifier = Modifier
                .padding(end = 16.dp, top = 16.dp)
                .align(Alignment.TopEnd)
                .size(110.dp, 32.dp)
                .background(color = titlebg)
        ) {
            BlurBox(Modifier.size(110.dp, 32.dp), alpha = 0.3F)
            Row(
                modifier = Modifier.align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_trend),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "9h : 12m : 26s",
                    style = MaterialTheme.typography.small.copy(color = Teal200),
                )
            }
        }
        val modifier = Modifier
            .padding(bottom = 8.dp)
            .align(Alignment.BottomCenter)
            .defaultMinSize(232.dp, 86.dp)
        Box(
            modifier = modifier
        ) {
            Box(
                modifier = Modifier
                    .defaultMinSize(232.dp, 86.dp)
                    .background(color = titlebg)
            )
            BlurBox(Modifier.size(232.dp, 86.dp), alpha = 0.25F)
            Column(modifier = Modifier.defaultMinSize(minWidth = 200.dp)) {
                Text(
                    text = "Dancing David",
                    style = MaterialTheme.typography.medium_bold,
                    modifier = Modifier.padding(start = 12.dp, top = 12.dp)
                )

                Row(
                    modifier = Modifier.defaultMinSize(minWidth = 220.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Current bid",
                            style = MaterialTheme.typography.small,
                            modifier = Modifier.padding(start = 12.dp)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = "7007 ETH",
                            style = MaterialTheme.typography.small_bold.copy(brush = fireBrush),
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1F))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .defaultMinSize(minHeight = 30.dp, minWidth = 90.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Place a bid", style = MaterialTheme.typography.small_bold)
                    }
                }
            }
        }
    }
}

@Composable
private fun NavBar() {
    val modifier = Modifier
        .padding(end = 24.dp)
        .fillMaxWidth()
        .defaultMinSize(minWidth = 327.dp, minHeight = 67.dp)
        .border(shape = RoundedCornerShape(12.dp), width = 1.dp, color = OffWhite)
    Box(modifier = Modifier.fillMaxWidth()){
        Box(
            modifier = modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minWidth = 327.dp, minHeight = 67.dp)
                    .border(shape = RoundedCornerShape(12.dp), width = 1.dp, color = OffWhite)
                    .background(color = titlebg, shape = RoundedCornerShape(12.dp))
            )
            Row(
                modifier = Modifier
                    .defaultMinSize(minWidth = 370.dp, minHeight = 67.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(contentAlignment = Alignment.TopCenter) {
                    BlurBox(
                        Modifier
                            .offset(y = (-24).dp)
                            .size(32.dp, 12.dp), alpha = 0.5F
                    )
                    Spacer(
                        modifier = Modifier
                            .offset(y = (-28).dp)
                            .size(32.dp, 4.dp)
                            .background(color = Teal200, shape = RoundedCornerShape(16.dp))
                    )
                    Icon(painter = painterResource(id = R.drawable.home), contentDescription = null)
                }
                Icon(painter = painterResource(id = R.drawable.heart), contentDescription = null)
                Image(painter = painterResource(id = R.drawable.home), contentDescription = null)
                Icon(painter = painterResource(id = R.drawable.cart), contentDescription = null)
                Icon(painter = painterResource(id = R.drawable.account), contentDescription = null)
            }
        }
        Box(modifier = Modifier
            .clickable { }
            .align(
                Alignment.Center
            ).offset(x = (-8).dp, y = (-4).dp)) {

            BlurBox(
                Modifier.offset(x = 5.dp, y = 5.dp)
                    .rotate(45F)
                    .size(65.dp, 65.dp), alpha = 0.3F, color = Color(0xFFFFB801)
            )
            Image(
                painter = painterResource(id = R.drawable.fire_fill),
                contentDescription = null)
        }
    }
}

val fireBrush = Brush.linearGradient(
    colors = listOf(
        Color(0xFFFFB801),
        Color(0xFFFF2F61)
    )
)