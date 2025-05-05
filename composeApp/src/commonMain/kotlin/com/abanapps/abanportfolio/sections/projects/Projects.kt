package com.abanapps.abanportfolio.sections.projects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abanapps.abanportfolio.sections.projects.components.ProjectCard
import com.abanapps.abanportfolio.utils.WindowSizeClass
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
fun Projects(){

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        val breakpoint = when {
            maxWidth < 890.dp -> WindowSizeClass.Compact
            maxWidth < 1440.dp -> WindowSizeClass.Medium
            else -> WindowSizeClass.Expanded
        }

        Box(
            modifier = Modifier.fillMaxWidth().background(Color.Black),
            contentAlignment = Alignment.Center
        )
        {

            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = if (breakpoint== WindowSizeClass.Expanded) 25.sdp else if (breakpoint == WindowSizeClass.Medium) 15.sdp else 10.sdp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.sdp)
            ) {
                Spacer(modifier = Modifier.height(10.sdp))
                Text("Projects", color = Color.White, fontSize = 15.ssp)


                when(breakpoint){

                    WindowSizeClass.Compact -> {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ProjectCard(modifier = Modifier.weight(1f),fontSizeFeatures = 8.ssp, breakPoint = breakpoint)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ProjectCard(modifier = Modifier.weight(1f),fontSizeFeatures = 8.ssp, breakPoint = breakpoint)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ProjectCard(modifier = Modifier.weight(1f),fontSizeFeatures = 8.ssp, breakPoint = breakpoint)
                        }

                    }
                    WindowSizeClass.Medium -> {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ProjectCard(modifier = Modifier.weight(1f))
                            ProjectCard(modifier = Modifier.weight(1f))

                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ProjectCard(modifier = Modifier.weight(1f))
                            ProjectCard(modifier = Modifier.weight(1f))

                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ProjectCard(modifier = Modifier.weight(1f))
                            ProjectCard(modifier = Modifier.weight(1f))

                        }

                    }

                    WindowSizeClass.Expanded -> {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ProjectCard(modifier = Modifier.weight(1f))
                            ProjectCard(modifier = Modifier.weight(1f))
                            ProjectCard(modifier = Modifier.weight(1f))
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.sdp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ProjectCard(modifier = Modifier.weight(1f))
                            ProjectCard(modifier = Modifier.weight(1f))
                            ProjectCard(modifier = Modifier.weight(1f))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.sdp))
            }
        }

    }

}