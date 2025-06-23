package dev.vladimirj.uptime.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import dev.vladimirj.uptime.getUptimeMessage
import kotlinx.coroutines.delay

@Composable
@Preview
fun App() {

    var message by remember { mutableStateOf(getUptimeMessage()) }
    LaunchedEffect(Unit) {
        while (true) {
            message = getUptimeMessage()
            delay(1000) // Refresh every second
        }
    }

    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = message
            )
        }
    }
}
