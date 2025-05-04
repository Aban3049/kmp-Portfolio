package com.abanapps.abanportfolio.components.header

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.ic_dark
import abanportfolio.composeapp.generated.resources.ic_light
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.skia.FontWeight

@Composable
fun TopHeader(
    onAboutClick: () -> Unit,
    onHomeClick: () -> Unit = {},
    onExperienceClick: () -> Unit = {},
    onProjectClick: () -> Unit = {},
    onContactClick: () -> Unit = {}
) {

    var isDarkMode by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier.fillMaxWidth().height(24.sdp)
            .background(Color(0xFFF5F5F5).copy(alpha = .7f))
            .padding(horizontal = 18.sdp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "M Aban", fontSize = 9.ssp, modifier = Modifier.weight(.5f))

        Row(
            modifier = Modifier.weight(2f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            HeaderButton(modifier = Modifier, text = "Home", onHomeClick)
            HeaderButton(modifier = Modifier, text = "About", onAboutClick)
            HeaderButton(modifier = Modifier, text = "Experience",onExperienceClick)
            HeaderButton(modifier = Modifier, text = "Projects",onProjectClick)
            HeaderButton(modifier = Modifier, text = "Contact",onContactClick)

        }

        IconButton(
            onClick = {
                isDarkMode = !isDarkMode
            },
            modifier = Modifier.weight(.5f)
        ) {
            AnimatedVisibility(visible = isDarkMode) {
                Icon(
                    painter = painterResource(Res.drawable.ic_light),
                    contentDescription = "ic_dark",
                    modifier = Modifier.padding(5.dp)
                )
            }
            if (!isDarkMode) {
                Icon(
                    painter = painterResource(Res.drawable.ic_dark),
                    contentDescription = "ic_dark",
                    modifier = Modifier.padding(5.dp)
                )
            }
        }

    }

}