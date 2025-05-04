package com.abanapps.abanportfolio.components.About

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.android
import abanportfolio.composeapp.generated.resources.compose
import abanportfolio.composeapp.generated.resources.firebase
import abanportfolio.composeapp.generated.resources.java
import abanportfolio.composeapp.generated.resources.python
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.abanapps.abanportfolio.components.profile.components.FavouriteCard
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
fun About(modifier: Modifier = Modifier){
            Box(
                modifier = Modifier.fillMaxWidth().background(Color.Black),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 25.sdp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.sdp)
                ) {
                    Spacer(modifier = Modifier.height(10.sdp))
                    Text("About Me", color = Color.White, fontSize = 15.ssp)
                    Text(
                        "This is dummy text for about me so keep up with it This is dummy text for about me so keep up with it This is dummy text for about me so keep up with it This is dummy text for about me so keep up with it This is dummy text for about me so keep up with it This is dummy text for about me so keep up with it",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 7.ssp
                    )

                    Text("Favourites", color = Color.White, fontSize = 12.ssp)

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.sdp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        FavouriteCard()
                        FavouriteCard(image = Res.drawable.compose, text = "Compose")
                        FavouriteCard(image = Res.drawable.java, text = "Java")
                        FavouriteCard(image = Res.drawable.android, text = "Android")
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.sdp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        FavouriteCard(image = Res.drawable.python, text = "Python")
                        FavouriteCard(image = Res.drawable.firebase, text = "Firebase")
                        FavouriteCard()
                        FavouriteCard()
                    }

                    Spacer(modifier=Modifier.height(16.sdp))

                }


            }
}