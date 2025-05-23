package com.abanapps.abanportfolio.sections.contact

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.ic_email
import abanportfolio.composeapp.generated.resources.ic_instagram
import abanportfolio.composeapp.generated.resources.ic_linkedin
import abanportfolio.composeapp.generated.resources.linkedin
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
fun Contact() {

    Box(
        modifier = Modifier.fillMaxWidth().background(Color(0xFF303033)),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 25.sdp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.sdp)
        ) {
            Spacer(modifier = Modifier.height(8.sdp))
            Text("Contact", color = Color(0xFF6F6F71), fontSize = 12.ssp)
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.sdp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                com.abanapps.abanportfolio.sections.contact.components.IconButton(url = "https://github.com/Aban3049")
                com.abanapps.abanportfolio.sections.contact.components.IconButton(image = Res.drawable.ic_instagram, url = "https://www.instagram.com/ch_m_aban/")
                com.abanapps.abanportfolio.sections.contact.components.IconButton(image = Res.drawable.ic_linkedin, url = "https://www.linkedin.com/in/aban-android-developer/")
                com.abanapps.abanportfolio.sections.contact.components.IconButton(image = Res.drawable.ic_email, url = "mailto:muhammadabandev@gmail.com.com")
            }
            Text(
                "2024 © AbanApps. All rights reserved.",
                color = Color(0xFF6F6F71),
                fontSize = 8.ssp
            )
            Text("Made with ❤️ by Aban", color = Color(0xFF6F6F71), fontSize = 8.ssp)
            Spacer(modifier = Modifier.height(3.sdp))
        }
    }


}

