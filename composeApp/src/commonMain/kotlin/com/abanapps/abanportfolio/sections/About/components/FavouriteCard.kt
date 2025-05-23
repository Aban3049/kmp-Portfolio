package com.abanapps.abanportfolio.sections.About.components

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.kotlin
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import com.abanapps.abanportfolio.utils.WindowSizeClass
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FavouriteCard(
    image: DrawableResource = Res.drawable.kotlin,
    text: String = "Kotlin",
    breakPoint: WindowSizeClass? = null
) {

    var isHovered by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.1f else 1.0f,
        label = "offset"
    )

    ElevatedCard(
        onClick = {},
        colors = CardDefaults.cardColors(Color(0xFF303033)),
        modifier = Modifier.scale(scale)
            .pointerHoverIcon(PointerIcon.Hand)
            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false }.size(if (breakPoint!=null) 68.sdp else 60.sdp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(image),
                contentDescription = "ic_kotlin",
                modifier = Modifier.align(Alignment.CenterHorizontally).size(32.sdp),
            )
            Spacer(modifier = Modifier.height(4.sdp))
            Text(text, color = Color.White, fontSize = 8.ssp)
        }

    }

}