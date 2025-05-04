package com.abanapps.abanportfolio.components.projects.components

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.video_editing_app_icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectCard(
    appName: String = "MP3 Converter",
    projectDate: String = "Jan 2025 - Feb 2025"
) {

    Card(
        colors = CardDefaults.cardColors(Color(0xFF404043))
    ) {

        Column(
            modifier = Modifier.padding(8.sdp),
            verticalArrangement = Arrangement.spacedBy(5.sdp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.sdp),
                modifier = Modifier
            ) {

                Image(
                    painter = painterResource(Res.drawable.video_editing_app_icon),
                    contentDescription = appName,
                    modifier = Modifier.size(36.sdp)
                )

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(2.sdp)
                ) {
                    Text(appName, color = Color.White, fontSize = 9.ssp)
                    Text(projectDate, color = Color.Gray, fontSize = 7.ssp)
                }



            }

            Text(
                "Key Features:",
                color = Color.White,
                fontSize = 8.ssp,
                fontWeight = FontWeight.Medium
            )

            Text("• Convert video to audio effortlessly", color = Color.White, fontSize = 6.ssp)
            Text("• Cut & merge audio and video files", color = Color.White, fontSize = 6.ssp)
            Text("• Full-featured video editor with trimming", color = Color.White, fontSize = 6.ssp)
            Text("• Convert files between multiple formats", color = Color.White, fontSize = 6.ssp)
            Text("• Compress videos without losing quality", color = Color.White, fontSize = 6.ssp)

        }

    }

}