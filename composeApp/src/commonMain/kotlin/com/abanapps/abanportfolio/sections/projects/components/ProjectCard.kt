package com.abanapps.abanportfolio.sections.projects.components

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.playstore
import abanportfolio.composeapp.generated.resources.video_editing_app_icon
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.abanapps.abanportfolio.utils.WindowSizeClass
import com.abanapps.abanportfolio.utils.openUrl
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectCard(
    appName: String = "MP3 Converter",
    appImage: DrawableResource = Res.drawable.video_editing_app_icon,
    projectDate: String = "Jan 2025 - Feb 2025",
    projectKeyFeatures: List<String> = listOf(
        "Convert video to audio effortlessly",
        "Cut & merge audio and video files",
        "Full-featured video editor with trimming",
        "Convert files between multiple formats",
        "Compress videos without losing quality"
    ),
    modifier: Modifier = Modifier,
    fontSizeFeatures: TextUnit = 6.ssp,
    breakPoint: WindowSizeClass? = null,
    onPlayStore: Boolean = false,
    appStoreLink: String = "https://play.google.com/store/apps/details?id=com.videotomp3audioconverter.convertmp4videotomp3audio&hl=en",
    appDownloads: String = "100k+"
) {

    var isHovered by remember {
        mutableStateOf(false)
    }
    val scale by animateFloatAsState(
        if (isHovered) 1.1f else 1.0f
    )

    Card(
        modifier =
            modifier,
        colors = CardDefaults.cardColors(Color(0xFF404043))
    ) {

        Column(
            modifier = Modifier.padding(8.sdp),
            verticalArrangement = Arrangement.spacedBy(5.sdp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.sdp),
                modifier = Modifier.fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(appImage),
                    contentDescription = appName,
                    modifier = Modifier.scale(scale).size(if (breakPoint != null && breakPoint == WindowSizeClass.Compact) 50.sdp else 40.sdp).pointerInput(PointerEventType.Enter) { isHovered = true }.pointerInput(
                        PointerEventType.Exit) { isHovered = false }.pointerHoverIcon(
                        PointerIcon.Hand).then(
                            if (onPlayStore){
                                Modifier.clickable {
                                    openUrl(appStoreLink)
                                }
                            }else{
                                Modifier
                            }
                        )
                )

                Column(
                    modifier = Modifier.height(IntrinsicSize.Min),
                    verticalArrangement = Arrangement.spacedBy(if (breakPoint != null && breakPoint == WindowSizeClass.Compact) 0.sdp else 2.sdp)
                ) {
                    if (breakPoint == WindowSizeClass.Compact && onPlayStore) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                appName,
                                color = Color.White,
                                fontSize = 9.ssp,
                                modifier = Modifier
                            )
                            Image(
                                painterResource(Res.drawable.playstore),
                                contentDescription = "ic_play_store",
                                modifier = Modifier.size(16.sdp).align(Alignment.CenterVertically)
                            )
                        }
                    } else {
                        Text(appName, color = Color.White, fontSize = 9.ssp, modifier = Modifier)
                    }
                    Text(projectDate, color = Color.Gray, fontSize = 7.ssp, modifier = Modifier)
                    if (breakPoint == WindowSizeClass.Medium && onPlayStore || breakPoint == WindowSizeClass.Expanded && onPlayStore) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(2.sdp)
                        ) {
                            Image(
                                painterResource(Res.drawable.playstore),
                                contentDescription = "ic_play_store",
                                modifier = Modifier.size(10.sdp)
                            )
                            Text(
                                appDownloads,
                                color = Color.Gray,
                                fontSize = 7.ssp,
                                modifier = Modifier)
                        }

                    }

                }


            }

            Text(
                "Key Features:",
                color = Color.White,
                fontSize = 8.ssp,
                fontWeight = FontWeight.Medium
            )

            projectKeyFeatures.forEach {
                Text("• $it", color = Color.White, fontSize = fontSizeFeatures)
            }

        }

    }

}