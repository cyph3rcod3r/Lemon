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

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.unit.dp
import com.cyberwalker.nftmarketplace.R
import com.cyberwalker.nftmarketplace.ui.theme.*

@Composable
fun DetailScreen(scaffoldState: ScaffoldState = rememberScaffoldState()) {
    Scaffold(modifier = Modifier.padding(24.dp),
        scaffoldState = scaffoldState,
        topBar = {
            Row(
                modifier = Modifier
                    .defaultMinSize(minHeight = 48.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier.clickable { },
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null
                )
                Text(text = "Dancing David", style = MaterialTheme.typography.headerLarge)
                Icon(
                    modifier = Modifier
                        .clickable { },
                    painter = painterResource(id = R.drawable.dots_vertical),
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
        Product()
        Spacer(modifier = Modifier.size(24.dp))
        FollowerCard(i = 1, padding = 0.dp)
        Spacer(modifier = Modifier.size(24.dp))
        NameRow()
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = "Amet minim mollit non deserunt ullamco est\n" +
                    "sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit.",
            style = MaterialTheme.typography.description
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 56.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Place Bid", style = MaterialTheme.typography.buttonText)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.icon_next),
                contentDescription = null
            )
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
private fun NameRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Dancing David", style = MaterialTheme.typography.headerLarge)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.eth), contentDescription = null)
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "7007 ETH",
                style = MaterialTheme.typography.buttonText.copy(brush = fireBrush),
            )
        }
    }
}

@Composable
fun Product() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 375.dp)
            .border(1.dp, OffWhite, RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_product_large),
            contentDescription = null,
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}