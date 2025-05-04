package com.abanapps.abanportfolio.components.experience

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.mobologics_logo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.abanapps.abanportfolio.components.experience.components.CompanySection
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
fun Experience() {

    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 25.sdp),
        verticalArrangement = Arrangement.spacedBy(12.sdp)
    ) {

        Text("Experience", fontSize = 15.ssp, fontWeight = FontWeight.Bold)

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.sdp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompanySection(
                image = Res.drawable.mobologics_logo,
                companyName = "Mobologics",
                role = "Junior Android Developer",
                timePeriod = "Dec 2024 - Present"
            )
            CompanySection()

        }

    }

}