package dev.vladimirj.uptime

import kotlin.test.Test
import kotlin.test.assertTrue

class WasmJsSystemUptimeProviderTest {
    @Test
    fun `system uptime should return non-negative value`() {
        val uptime = getSystemUptimeInSeconds()
        assertTrue(
            uptime >= 0,
            "System uptime should be non-negative"
        )
    }
}