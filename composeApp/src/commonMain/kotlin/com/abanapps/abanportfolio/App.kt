package com.abanapps.abanportfolio

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abanapps.abanportfolio.sections.About.About
import com.abanapps.abanportfolio.sections.contact.Contact
import com.abanapps.abanportfolio.sections.experience.Experience
import com.abanapps.abanportfolio.sections.header.TopHeader
import com.abanapps.abanportfolio.sections.profile.Profile
import com.abanapps.abanportfolio.sections.projects.Projects
import com.abanapps.abanportfolio.utils.Utils
import com.abanapps.abanportfolio.utils.WindowSizeClass
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedDrawerIndex by remember {
        mutableIntStateOf(0)
    }

    MaterialTheme {

        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet(
                    drawerContainerColor = Color.White,
                    drawerShape = CardDefaults.elevatedShape
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight().width(360.sdp)
                            .padding(horizontal = 5.sdp, vertical = 8.sdp)
                    ) {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "")
                        }
                        Utils.drawerItems.forEachIndexed { index, item ->
                            NavigationDrawerItem(
                                label = {
                                    Text(item, color = Color(0xFF45424B))
                                },
                                selected = selectedDrawerIndex == index,
                                onClick = {
                                    selectedDrawerIndex = index
                                    coroutineScope.launch {
                                        listState.animateScrollToItem(index)
                                        drawerState.close()
                                    }

                                },
                                colors = NavigationDrawerItemDefaults.colors(
                                    selectedContainerColor = Color(
                                        0xFFEDEDED
                                    )
                                ),
                                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                    .padding(vertical = 2.sdp),
                            )

                        }
                    }

                }
            },
            modifier = Modifier,
            drawerState = drawerState,
            gesturesEnabled = true,
            content = {
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
                            },
                            onHamburgerClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        )
                    },
                    containerColor = Color.White,
                    contentWindowInsets = WindowInsets(0.dp)
                ) {

                    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

                        val breakpoint = when {
                            maxWidth < 550.dp -> WindowSizeClass.Compact
                            maxWidth < 1050.dp -> WindowSizeClass.Medium
                            else -> WindowSizeClass.Expanded
                        }
                        LazyColumn(
                            modifier = Modifier.padding(it).fillMaxSize(),
                            state = listState
                        ) {

                            item() {
                                Profile()
                            }
                            item {
                                About(modifier = Modifier.offset(y = if (breakpoint != WindowSizeClass.Compact)(-25).dp else 0.dp))
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
        )


    }
}