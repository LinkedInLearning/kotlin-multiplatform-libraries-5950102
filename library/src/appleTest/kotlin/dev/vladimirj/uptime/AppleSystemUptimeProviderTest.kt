package dev.vladimirj.uptime

import kotlin.test.Test
import kotlin.test.assertTrue

class AppleSystemUptimeProviderTest {
    @Test
    fun `Apple system uptime should be greater than zero`() {
        val uptime = getSystemUptimeInSeconds()
        assertTrue(uptime > 0)
    }

    @Test
    fun `Apple system uptime should increase over time`() {
        val firstUptime = getSystemUptimeInSeconds()
        val twoSecondsInMicroseconds = 2_000_000u
        platform.posix.usleep(twoSecondsInMicroseconds)
        val secondUptime = getSystemUptimeInSeconds()
        assertTrue(
            secondUptime > firstUptime,
            "Second uptime reading ($secondUptime) should be greater than or equal to the first ($firstUptime)"
        )
    }
}