package dev.vladimirj.uptime

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AndroidSystemUptimeProviderInstrumentedTest {
    @Test
    fun androidSystemUptimeShouldBeGreaterThanZero() {
        val uptime = getSystemUptimeInSeconds()
        assertTrue(uptime > 0)
    }

    @Test
    fun systemUptimeShouldIncreaseOverTime() {
        val firstUptime = getSystemUptimeInSeconds()
        Thread.sleep(2000)
        val secondUptime = getSystemUptimeInSeconds()
        assertTrue(secondUptime > firstUptime)
    }
}