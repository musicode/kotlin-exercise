package com.musicode.weather.extension

import java.text.SimpleDateFormat
import java.util.*

fun Long.toDate(pattern: String): String {
    val sf = SimpleDateFormat(pattern)
    return sf.format(Date(this * 1000))
}