package com.abanapps.abanportfolio.utils

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.android
import abanportfolio.composeapp.generated.resources.compose
import abanportfolio.composeapp.generated.resources.firebase
import abanportfolio.composeapp.generated.resources.java
import abanportfolio.composeapp.generated.resources.python
import androidx.compose.runtime.Composable
import com.abanapps.abanportfolio.sections.About.components.FavouriteCard

@Composable
fun favouritesList() = listOf(
    FavouriteCard(),
    FavouriteCard(image = Res.drawable.compose, text = "Compose"),
    FavouriteCard(image = Res.drawable.java, text = "Java"),
    FavouriteCard(image = Res.drawable.android, text = "Android"),
    FavouriteCard(image = Res.drawable.python, text = "Python"),
    FavouriteCard(image = Res.drawable.firebase, text = "Firebase"),
    FavouriteCard(),
    FavouriteCard(),
)