package com.abanapps.abanportfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.compose_multiplatform
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.node.Ref
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.abanapps.abanportfolio.components.About.About
import com.abanapps.abanportfolio.components.contact.Contact
import com.abanapps.abanportfolio.components.experience.Experience
import com.abanapps.abanportfolio.components.header.TopHeader
import com.abanapps.abanportfolio.components.profile.Profile
import com.abanapps.abanportfolio.components.projects.Projects
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {

        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            topBar = {
                TopHeader(
                    onAboutClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(1)
                        }
                    },
                    onHomeClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    },
                    onExperienceClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(2)
                        }
                    },
                    onProjectClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(3)
                        }
                    },
                    onContactClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(4)
                        }
                    })
            },
            containerColor = Color.White,
            contentWindowInsets = WindowInsets(0.dp)
        ) {

            LazyColumn(
                modifier = Modifier.padding(it).fillMaxSize(),
                state = listState
            ) {

                item() {
                    Profile()
                }
                item {
                    About(modifier = Modifier.offset(x = (-25).dp))
                }

                item {
                    Spacer(modifier = Modifier.height(15.sdp))
                    Experience()
                    Spacer(modifier = Modifier.height(30.sdp))
                }

                item {
                    Projects()
                    Spacer(modifier = Modifier.height(30.sdp))
                }

                item {
                    Contact()
                }

            }


        }

    }
}