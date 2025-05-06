package com.abanapps.abanportfolio.utils

actual fun openUrl(url: String) {
    js("window.open(url, '_blank')")
}