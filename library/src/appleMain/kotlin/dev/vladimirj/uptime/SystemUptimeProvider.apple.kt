package dev.vladimirj.uptime

import platform.Foundation.NSProcessInfo

actual fun getSystemUptimeInSeconds(): Long {
    return NSProcessInfo.processInfo.systemUptime.toLong()
}