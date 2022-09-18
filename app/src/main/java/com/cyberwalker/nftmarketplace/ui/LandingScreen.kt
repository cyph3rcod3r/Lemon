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
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cyberwalker.nftmarketplace.R
import com.cyberwalker.nftmarketplace.ui.theme.Teal200
import com.cyberwalker.nftmarketplace.ui.theme.buttonText
import com.cyberwalker.nftmarketplace.ui.theme.large

@OptIn(ExperimentalTextApi::class)
@Composable
fun LandingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_bg_login),
            contentDescription = null,
        )
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_core_bg),
            contentDescription = null,
            alpha = 0.5F
        )
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize()
                .semantics { contentDescription = "Landing Screen" }
        ) {
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = "ManaGe",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.large.copy(
                    brush = brush
                ), textAlign = TextAlign.Center
            )
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                BlurBox()
                Text(
                    text = "NFT",
                    style = MaterialTheme.typography.large.copy(
                        brush = brush
                    )
                )
            }
            Text(
                text = "more",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.large.copy(
                    brush = brush
                ), textAlign = TextAlign.Center
            )
            Text(
                text = "Easily",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.large.copy(
                    brush = brush
                ), textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1F))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 56.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Connect Wallet", style = MaterialTheme.typography.buttonText)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.icon_next),
                    contentDescription = null
                )
            }
        }
    }
}

val brush = Brush.linearGradient(
    colors = listOf(
        Teal200,
        Color.White
    )
)

@Composable
private fun BlurBox() {
    val paint by remember {
        val value = android.graphics.Paint()
        value.maskFilter = BlurMaskFilter(12F, BlurMaskFilter.Blur.NORMAL)
        value.color = Teal200.copy(alpha = 0.4F).toArgb()
        mutableStateOf(value)
    }

    Canvas(
        modifier = Modifier
            .size(258.dp, 68.dp)
    ){
        val width = size.width
        val height = size.height

        drawIntoCanvas {
            it.nativeCanvas.drawRect(0F, 0F, width, height, paint)
        }
    }
}