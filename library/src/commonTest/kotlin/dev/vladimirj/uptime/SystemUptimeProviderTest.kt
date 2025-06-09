package dev.vladimirj.uptime

import kotlin.test.Test
import kotlin.test.assertEquals

class SystemUptimeProviderTest {

    @Test
    fun `return uptime message when positive time is provided`() {
        assertEquals("The system has been up for 1 seconds", getUptimeMessage(1))
    }

    @Test
    fun `return uptime error message when negative time is provided`() {
        assertEquals("Error! System uptime unknown!", getUptimeMessage(-1))
    }
}