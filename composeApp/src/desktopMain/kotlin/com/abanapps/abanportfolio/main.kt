package com.abanapps.abanportfolio

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Aban Portfolio",
    ) {
            App()
    }
}

