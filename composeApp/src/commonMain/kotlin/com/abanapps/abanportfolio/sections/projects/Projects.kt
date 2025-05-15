package com.abanapps.abanportfolio.sections.projects

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.ai_chat_keyboard_icon
import abanportfolio.composeapp.generated.resources.audio_amplifier_icon
import abanportfolio.composeapp.generated.resources.bt_remote_app_icon
import abanportfolio.composeapp.generated.resources.ppt_file_viewer_icon
import abanportfolio.composeapp.generated.resources.video_editing_app_icon
import abanportfolio.composeapp.generated.resources.vin_icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.abanapps.abanportfolio.sections.projects.components.ProjectCard
import com.abanapps.abanportfolio.utils.Utils
import com.abanapps.abanportfolio.utils.WindowSizeClass
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource
import kotlin.math.abs

@Composable
fun Projects() {

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000L)

            val nextIndex = if (listState.firstVisibleItemIndex < Utils.projectsList.lastIndex) {
                listState.firstVisibleItemIndex + 1
            } else {
                0
            }

            coroutineScope.launch {
                listState.animateScrollToItem(nextIndex)
            }
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        val breakpoint = when {
            maxWidth < 890.dp -> WindowSizeClass.Compact
            maxWidth < 1440.dp -> WindowSizeClass.Medium
            else -> WindowSizeClass.Expanded
        }

        Box(
            modifier = Modifier.fillMaxWidth().background(Color.Black),
            contentAlignment = Alignment.Center
        )
        {

            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = if (breakpoint == WindowSizeClass.Expanded) 25.sdp else if (breakpoint == WindowSizeClass.Medium) 15.sdp else 10.sdp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.sdp)
            ) {
                Spacer(modifier = Modifier.height(10.sdp))
                Text("Projects", color = Color.White, fontSize = 15.ssp)


                when (breakpoint) {

                    WindowSizeClass.Compact -> {

                        Box(modifier = Modifier.fillMaxWidth()) {

                            LazyRow(
                                state = listState,
                                modifier = Modifier.align(Alignment.Center),
                                horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            ) {

                                itemsIndexed(Utils.projectsList) { index, item ->


                                    ProjectCard(
                                        breakPoint = breakpoint,
                                        modifier = Modifier,
                                        appName = item.appName,
                                        appImage = item.appImage,
                                        projectDate = item.projectDate,
                                        projectKeyFeatures = item.projectKeyFeatures,
                                        onPlayStore = item.onPlayStore,
                                        appStoreLink = item.appStoreLink,
                                        appDownloads = item.appDownloads,
                                        fontSizeFeatures = 10.ssp,
                                    )
                                }

                            }

                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        val target =
                                            (listState.firstVisibleItemIndex - 1).coerceAtLeast(0)
                                        listState.animateScrollToItem(target)
                                    }
                                },
                                modifier = Modifier.background(
                                    Color.LightGray.copy(alpha = .5f),
                                    shape = CircleShape
                                ).align(Alignment.CenterStart),
                                colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                            ) {
                                Icon(Icons.Rounded.ArrowBackIosNew, contentDescription = "Previous")
                            }

                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        val target =
                                            (listState.firstVisibleItemIndex + 1) % Utils.projectsList.size
                                        listState.animateScrollToItem(target)
                                    }
                                },
                                modifier = Modifier.background(
                                    Color.LightGray.copy(alpha = .5f),
                                    shape = CircleShape
                                ).align(Alignment.CenterEnd),
                                colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                            ) {
                                Icon(
                                    Icons.AutoMirrored.Rounded.ArrowForwardIos,
                                    contentDescription = "Next"
                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(16.sdp))


//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            ProjectCard(
//                                modifier = Modifier.weight(1f),
//                                fontSizeFeatures = 8.ssp,
//                                breakPoint = breakpoint,
//                                onPlayStore = true
//                            )
//                        }
//
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            ProjectCard(
//                                modifier = Modifier.weight(1f),
//                                fontSizeFeatures = 8.ssp,
//                                breakPoint = breakpoint,
//                                appName = "AI Chat Keyboard",
//                                projectDate = "Dec 2024 - Dec 2024",
//                                appImage = Res.drawable.ai_chat_keyboard_icon,
//                                projectKeyFeatures = listOf(
//                                    "Multi-functional AI Chat Keyboard",
//                                    "Customizable keyboard themes",
//                                    "Intelligent text correction using Gemini",
//                                    "AI-based word suggestions for typing",
//                                    "Portrait & landscape mode compatibility"
//                                )
//                            )
//                        }
//
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            ProjectCard(
//                                modifier = Modifier.weight(1f),
//                                fontSizeFeatures = 8.ssp,
//                                breakPoint = breakpoint,
//                                appName = "BT Tv Remote",
//                                projectDate = "Feb 2025 - Mar 2024",
//                                appImage = Res.drawable.bt_remote_app_icon,
//                                projectKeyFeatures = listOf(
//                                    "Bluetooth remote control for TVs",
//                                    "Gamepad mode for gaming",
//                                    "Google Cast for media streaming",
//                                    "Channel & volume control",
//                                    "Multi-language support"
//                                )
//                            )
//                        }

                    }

                    else -> {


                        Box(modifier = Modifier.fillMaxWidth()) {

                            LazyRow(
                                state = listState,
                                modifier = Modifier.align(Alignment.Center),
                                horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            ) {
                                itemsIndexed(Utils.projectsList) { index, item ->


                                    ProjectCard(
                                        breakPoint = breakpoint,
                                        modifier = Modifier,
                                        appName = item.appName,
                                        appImage = item.appImage,
                                        projectDate = item.projectDate,
                                        projectKeyFeatures = item.projectKeyFeatures,
                                        onPlayStore = item.onPlayStore,
                                        appStoreLink = item.appStoreLink,
                                        appDownloads = item.appDownloads,
                                        fontSizeFeatures = 6.ssp,
                                    )
                                }
                            }

                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        val target =
                                            (listState.firstVisibleItemIndex - 1).coerceAtLeast(0)
                                        listState.animateScrollToItem(target)
                                    }
                                },
                                modifier = Modifier.background(
                                    Color.LightGray.copy(alpha = .5f),
                                    shape = CircleShape
                                ).align(Alignment.CenterStart),
                                colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                            ) {
                                Icon(Icons.Rounded.ArrowBackIosNew, contentDescription = "Previous")
                            }

                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        val target =
                                            (listState.firstVisibleItemIndex + 1) % Utils.projectsList.size
                                        listState.animateScrollToItem(target)
                                    }
                                },
                                modifier = Modifier.background(
                                    Color.LightGray.copy(alpha = .5f),
                                    shape = CircleShape
                                ).align(Alignment.CenterEnd),
                                colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                            ) {
                                Icon(
                                    Icons.AutoMirrored.Rounded.ArrowForwardIos,
                                    contentDescription = "Next"
                                )
                            }


                        }


                        Spacer(modifier = Modifier.height(16.sdp))
                    }
                }

            }

        }
    }
}