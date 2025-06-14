package dev.vladimirj.uptime

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowSystemClock
import java.time.Duration
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
class AndroidSystemUptimeProviderRobolectricTest {

    @Test
    fun `system uptime should return correct uptime`() {
        ShadowSystemClock.advanceBy(Duration.ofSeconds(10))
        val uptime = getSystemUptimeInSeconds()
        assertEquals(10, uptime)
    }
}