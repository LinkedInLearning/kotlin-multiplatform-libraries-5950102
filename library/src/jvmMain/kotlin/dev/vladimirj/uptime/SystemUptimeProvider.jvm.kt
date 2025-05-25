package dev.vladimirj.uptime
import java.lang.management.ManagementFactory

actual fun getSystemUptimeInSeconds(): Long {
    return ManagementFactory.getRuntimeMXBean().uptime / 1000
}