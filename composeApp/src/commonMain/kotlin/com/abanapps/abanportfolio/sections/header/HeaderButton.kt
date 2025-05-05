package com.abanapps.abanportfolio.sections.header

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun HeaderButton(modifier: Modifier = Modifier, text: String,onClick: () -> Unit = {}) {
    TextButton(
        onClick = {
            onClick()
        },
        modifier = modifier.padding(horizontal = 4.sdp)
    ) {
        Text(text, color = Color.Black)
    }
}