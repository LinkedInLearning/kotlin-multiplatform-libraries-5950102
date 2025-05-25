package dev.vladimirj.uptime

private val startTime = getCurrentTimeMillis().toLong()

actual fun getSystemUptimeInSeconds(): Long {
    return (getCurrentTimeMillis().toLong() - startTime) / 1000
}

@JsFun("() => (new Date()).getTime()")
external fun getCurrentTimeMillis(): Double
