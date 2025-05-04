package com.abanapps.abanportfolio.components.profile.components

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.kotlin
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import network.chaintech.sdpcomposemultiplatform.sdp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun FavouriteCard(image: DrawableResource = Res.drawable.kotlin,text: String = "Kotlin") {


    ElevatedCard(
        onClick = {},
        colors = CardDefaults.cardColors(Color(0xFF303033)),
        modifier = Modifier.size(60.sdp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(image),
                contentDescription = "ic_kotlin",
                modifier = Modifier.size(32.sdp)
            )
            Spacer(modifier = Modifier.height(4.sdp))
            Text(text, color = Color.White)
        }

    }

}