package dev.vladimirj.uptime

import platform.Foundation.NSProcessInfo

fun getSystemUptimeInSeconds(): Long {
    return NSProcessInfo.processInfo.systemUptime.toLong()
}