package dev.vladimirj.uptime
import java.lang.management.ManagementFactory

fun getSystemUptimeInSeconds(): Long {
    return ManagementFactory.getRuntimeMXBean().uptime / 1000
}