package dev.vladimirj.uptime

import android.os.SystemClock

fun getSystemUptimeInSeconds(): Long {
    return SystemClock.elapsedRealtime() / 1000
}