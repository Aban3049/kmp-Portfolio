package com.abanapps.abanportfolio.sections.About

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.android
import abanportfolio.composeapp.generated.resources.compose
import abanportfolio.composeapp.generated.resources.firebase
import abanportfolio.composeapp.generated.resources.java
import abanportfolio.composeapp.generated.resources.ktor
import abanportfolio.composeapp.generated.resources.python
import abanportfolio.composeapp.generated.resources.sqlite
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.abanapps.abanportfolio.sections.About.components.FavouriteCard
import com.abanapps.abanportfolio.utils.WindowSizeClass
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
fun About(modifier: Modifier = Modifier) {

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        val breakpoint = when {
            maxWidth < 600.dp -> WindowSizeClass.Compact
            maxWidth < 840.dp -> WindowSizeClass.Medium
            else -> WindowSizeClass.Expanded
        }


        Box(
            modifier = modifier.fillMaxWidth().background(Color.Black),
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
                    "I'm a passionate Android Developer with over a year of experience building clean, user-friendly mobile apps. I enjoy turning ideas into real, working products and have worked on everything from multimedia tools to smart TV remotes. I’m currently exploring Kotlin Multiplatform (KMP), Compose Multiplatform (CMP), Swift, and diving deeper into core Android concepts to level up my skills.",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 9.ssp,
                    modifier = Modifier.padding(4.dp),
                )

                Text("Favourites", color = Color.White, fontSize = 12.ssp)

                when (breakpoint) {
                    WindowSizeClass.Expanded -> {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FavouriteCard()
                            FavouriteCard(image = Res.drawable.compose, text = "Compose")
                            FavouriteCard(image = Res.drawable.java, text = "Java")
                            FavouriteCard(image = Res.drawable.android, text = "Android")

                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FavouriteCard(image = Res.drawable.python, text = "Python")
                            FavouriteCard(image = Res.drawable.firebase, text = "Firebase")
                            FavouriteCard(image = Res.drawable.ktor, text = "Ktor")
                            FavouriteCard(image = Res.drawable.sqlite, text = "SQLite")
                        }


                    }

                    else -> {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FavouriteCard(breakPoint = breakpoint)
                            FavouriteCard(
                                image = Res.drawable.compose,
                                text = "Compose",
                                breakPoint = breakpoint
                            )
                            FavouriteCard(
                                image = Res.drawable.java,
                                text = "Java",
                                breakPoint = breakpoint
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FavouriteCard(
                                image = Res.drawable.android,
                                text = "Android",
                                breakPoint = breakpoint
                            )
                            FavouriteCard(
                                image = Res.drawable.python,
                                text = "Python",
                                breakPoint = breakpoint
                            )
                            FavouriteCard(
                                image = Res.drawable.firebase,
                                text = "Firebase",
                                breakPoint = breakpoint
                            )
                        }


                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FavouriteCard(image = Res.drawable.ktor, text = "Ktor",breakPoint = breakpoint)
                            FavouriteCard(image = Res.drawable.sqlite, text = "SQLite",breakPoint = breakpoint)
                        }
                    }

                }



                Spacer(modifier = Modifier.height(16.sdp))

            }


        }
    }
}