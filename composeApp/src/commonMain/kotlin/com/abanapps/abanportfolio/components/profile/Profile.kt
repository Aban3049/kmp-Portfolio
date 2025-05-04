package com.abanapps.abanportfolio.components.profile

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.github
import abanportfolio.composeapp.generated.resources.linkedin
import abanportfolio.composeapp.generated.resources.profile_bg
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Profile() {

    var isHovered by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.1f else 1f,
        label = "offset"
    )



    Box(
        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min).paint(
            painter = painterResource(Res.drawable.profile_bg),
        )
    ) {

        Column(
            modifier = Modifier.fillMaxHeight()
                .padding(horizontal = 14.sdp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Hi, I'm Aban", modifier = Modifier, fontSize = 25.ssp)
            Text("Android Developer", modifier = Modifier, fontSize = 25.ssp)
            Text("Software Engineer and Android Developer Specialized in\nmobile application development for Android using Kotlin")
            Spacer(modifier = Modifier.height(8.sdp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.sdp)
            ) {

                ElevatedButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6848E5)),
                    modifier = Modifier.scale(scale)
                        .pointerHoverIcon(PointerIcon.Hand)
                        .onPointerEvent(PointerEventType.Enter) { isHovered = true }
                        .onPointerEvent(PointerEventType.Exit) { isHovered = false }
                ) {
                    Text("Follow on Github", modifier = Modifier.padding(4.sdp))
                    Icon(
                        painter = painterResource(Res.drawable.github),
                        contentDescription = "ic_github",
                        modifier = Modifier.size(24.dp)
                    )
                }

                OutlinedButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(
                        "Follow on Linkedin",
                        modifier = Modifier.padding(4.sdp),
                        color = Color.Black
                    )
                    Icon(
                        painter = painterResource(Res.drawable.linkedin),
                        contentDescription = "ic_linkedin",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }

            }
        }


    }

}