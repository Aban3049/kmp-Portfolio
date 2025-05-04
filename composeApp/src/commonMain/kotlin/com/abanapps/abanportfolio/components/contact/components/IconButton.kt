package com.abanapps.abanportfolio.components.contact.components

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.github
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun IconButton(
    image: DrawableResource = Res.drawable.github
){

    IconButton(
        onClick = {},
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = Color(0xFF6F6F71)
        )
    ) {
        Icon(painter = painterResource(image), contentDescription = "")
    }

}