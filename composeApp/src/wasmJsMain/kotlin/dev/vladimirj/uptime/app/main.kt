package dev.vladimirj.uptime.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    try {
        ComposeViewport(document.body!!) {
            App()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}