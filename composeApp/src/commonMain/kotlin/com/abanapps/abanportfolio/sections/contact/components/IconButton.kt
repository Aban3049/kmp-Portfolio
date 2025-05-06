package com.abanapps.abanportfolio.sections.contact.components

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.github
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import com.abanapps.abanportfolio.utils.openUrl
import network.chaintech.sdpcomposemultiplatform.sdp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun IconButton(
    image: DrawableResource = Res.drawable.github,
    url: String
){

    IconButton(
        onClick = {
            openUrl(url)
        },
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = Color(0xFF6F6F71)
        ),
        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
    ) {
        Icon(painter = painterResource(image), contentDescription = "")
    }

}