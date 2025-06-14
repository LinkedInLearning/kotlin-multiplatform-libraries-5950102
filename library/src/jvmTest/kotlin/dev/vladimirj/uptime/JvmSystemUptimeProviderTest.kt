package dev.vladimirj.uptime

import kotlin.test.Test
import kotlin.test.assertTrue

class JvmSystemUptimeProviderTest {
    @Test
    fun `system uptime should return non-negative value`() {
        val uptime = getSystemUptimeInSeconds()
        assertTrue(
            uptime >= 0,
            "System uptime should be non-negative"
        )
    }

    @Test
    fun `JVM system uptime should increase over time`() {
        val firstUptime = getSystemUptimeInSeconds()
        Thread.sleep(2000)
        val secondUptime = getSystemUptimeInSeconds()
        assertTrue(
            secondUptime > firstUptime,
            "Second uptime reading ($secondUptime) should be greater than the first ($firstUptime)"
        )
    }
}