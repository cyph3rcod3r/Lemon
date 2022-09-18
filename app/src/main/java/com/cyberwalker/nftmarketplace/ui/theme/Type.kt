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
package com.cyberwalker.nftmarketplace.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cyberwalker.nftmarketplace.R

val syncopate = FontFamily(Font(R.font.syncopate, FontWeight.Normal), Font(R.font.syncopate_bold, FontWeight.Bold))
val gilroy = FontFamily(Font(R.font.gilroy, FontWeight.Normal), Font(R.font.gilroy_bold, FontWeight.Bold))

val Typography.large: TextStyle
    get() = TextStyle(
        fontFamily = syncopate,
        fontWeight = FontWeight.W700,
        fontSize = 48.sp,
    )


val Typography.buttonText: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
    )

val Typography.small_bold: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W700,
        fontSize = 12.sp,
    )

val Typography.small: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
    )

val Typography.medium_bold: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
    )

val Typography.header: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
    )

val Typography.headerLarge: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
    )

val Typography.description: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W300,
        fontSize = 12.sp,
    )


// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)