package dev.vladimirj.uptime

fun getUptimeMessage(uptimeInSeconds: Long = getSystemUptimeInSeconds()): String {
    return if (uptimeInSeconds >= 0) {
        "The system has been up for $uptimeInSeconds seconds"
    } else {
        "Error! System uptime unknown!"
    }
}

internal expect fun getSystemUptimeInSeconds(): Long