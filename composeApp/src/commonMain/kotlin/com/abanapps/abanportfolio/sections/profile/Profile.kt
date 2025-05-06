package com.abanapps.abanportfolio.sections.profile

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.github
import abanportfolio.composeapp.generated.resources.linkedin
import abanportfolio.composeapp.generated.resources.profile_bg
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.abanapps.abanportfolio.utils.WindowSizeClass
import com.abanapps.abanportfolio.utils.openUrl
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

    var isHoveredLinkedinButton by  remember { mutableStateOf(false) }
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        val breakpoint = when {
            maxWidth < 700.dp -> WindowSizeClass.Compact
            maxWidth < 1050.dp -> WindowSizeClass.Medium
            else -> WindowSizeClass.Expanded
        }

        Box(
            modifier = Modifier.fillMaxWidth().then(
                when (breakpoint) {
                    WindowSizeClass.Compact -> Modifier.height(260.sdp)
                    WindowSizeClass.Medium -> Modifier.height(600.dp)
                    WindowSizeClass.Expanded -> Modifier.height(770.dp)
                }
            ).paint(
                painter = painterResource(Res.drawable.profile_bg),
                contentScale = when (breakpoint) {
                    WindowSizeClass.Compact -> ContentScale.FillHeight
                    else -> ContentScale.Crop
                }
            )
        ) {

            Column(
                modifier = Modifier.fillMaxHeight()
                    .padding(horizontal = 14.sdp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text("Hi, I'm Aban", modifier = Modifier, fontSize = if (breakpoint== WindowSizeClass.Medium) 19.ssp else 25.ssp)
                Text("Android Developer", modifier = Modifier, fontSize = if (breakpoint== WindowSizeClass.Medium) 19.ssp else 25.ssp)
                if (breakpoint== WindowSizeClass.Compact){
                    Text("Software Engineer and Android Developer\nSpecialized in mobile application development\nfor Android using Kotlin",fontSize =  8.ssp)
                }else {
                    Text(
                        "Software Engineer and Android Developer Specialized in\nmobile application development for Android using Kotlin",
                        fontSize = if (breakpoint == WindowSizeClass.Medium) 6.ssp else 8.ssp
                    )
                }
                Spacer(modifier = Modifier.height(8.sdp))
                if (breakpoint == WindowSizeClass.Expanded){
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
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (!isHoveredLinkedinButton) Color.Transparent else Color(
                                    0xFFF5F5F5
                                ).copy(alpha = .7f)
                            ),
                            modifier = Modifier
                                .pointerHoverIcon(PointerIcon.Hand)
                                .onPointerEvent(PointerEventType.Enter) {
                                    isHoveredLinkedinButton = true
                                }
                                .onPointerEvent(PointerEventType.Exit) {
                                    isHoveredLinkedinButton = false
                                }
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
                }else{
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(5.sdp)
                    ) {
                        ElevatedButton(
                            onClick = {
                                openUrl("https://github.com/Aban3049")
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6848E5)),
                            modifier = Modifier.scale(scale)
                                .pointerHoverIcon(PointerIcon.Hand)
                                .onPointerEvent(PointerEventType.Enter) { isHovered = true }
                                .onPointerEvent(PointerEventType.Exit) { isHovered = false }
                        ) {
                            Text("Follow on Github  ", modifier = Modifier.padding(4.sdp))
                            Icon(
                                painter = painterResource(Res.drawable.github),
                                contentDescription = "ic_github",
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        OutlinedButton(
                            onClick = {
                                openUrl("https://www.linkedin.com/in/aban-android-developer/")
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (!isHoveredLinkedinButton) Color.Transparent else Color(
                                    0xFFF5F5F5
                                ).copy(alpha = .7f)
                            ),
                            modifier = Modifier
                                .pointerHoverIcon(PointerIcon.Hand)
                                .onPointerEvent(PointerEventType.Enter) {
                                    isHoveredLinkedinButton = true
                                }
                                .onPointerEvent(PointerEventType.Exit) {
                                    isHoveredLinkedinButton = false
                                }
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

    }

}