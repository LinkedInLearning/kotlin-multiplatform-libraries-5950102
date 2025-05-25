package dev.vladimirj.uptime

import android.os.SystemClock

actual fun getSystemUptimeInSeconds(): Long {
    return SystemClock.elapsedRealtime() / 1000
}