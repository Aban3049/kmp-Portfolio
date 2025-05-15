package com.abanapps.abanportfolio.models

import org.jetbrains.compose.resources.DrawableResource

data class Project(
    val appName: String,
    val appImage: DrawableResource,
    val projectDate: String,
    val projectKeyFeatures: List<String>,
    val onPlayStore: Boolean = false,
    val appStoreLink: String? = null,
    val appDownloads: String? = null,
)
