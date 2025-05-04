package com.abanapps.abanportfolio.components.experience.components

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.micro_web_logo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun CompanySection(
    image: DrawableResource = Res.drawable.micro_web_logo,
    companyName: String = "MicroWeb Solutions Pvt. Ltd",
    role: String = "Android Developer Internship",
    timePeriod: String = "Jun 2024 - Nov 2024"
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.sdp)
    ) {

        ElevatedCard(
            onClick = {},
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = companyName,
                modifier = Modifier.padding(8.sdp).size(28.sdp).align(Alignment.CenterHorizontally)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(2.sdp)
        ) {
            Text(companyName, fontSize = 9.ssp, fontWeight = FontWeight.Medium)
            Text(role, fontSize = 6.ssp, color = Color.Gray)
            Text(timePeriod, fontSize = 6.ssp, color = Color.Gray)
        }


    }

}