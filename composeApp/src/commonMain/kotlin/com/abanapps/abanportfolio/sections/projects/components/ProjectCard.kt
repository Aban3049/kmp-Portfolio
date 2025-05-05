package com.abanapps.abanportfolio.sections.projects.components

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.video_editing_app_icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.abanapps.abanportfolio.utils.WindowSizeClass
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectCard(
    appName: String = "MP3 Converter",
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
    breakPoint: WindowSizeClass?=null
) {

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
                    painter = painterResource(Res.drawable.video_editing_app_icon),
                    contentDescription = appName,
                    modifier = Modifier.size(if (breakPoint!=null && breakPoint== WindowSizeClass.Compact)50.sdp else 40.sdp)
                )

                Column(
                    modifier = Modifier.height(IntrinsicSize.Min),
                    verticalArrangement = Arrangement.spacedBy(if (breakPoint!=null && breakPoint== WindowSizeClass.Compact)0.sdp else 2.sdp)
                ) {
                    Text(appName, color = Color.White, fontSize = 9.ssp, modifier = Modifier)
                    Text(projectDate, color = Color.Gray, fontSize = 7.ssp,modifier = Modifier)
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