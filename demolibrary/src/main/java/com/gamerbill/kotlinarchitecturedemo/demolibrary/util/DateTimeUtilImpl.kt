package com.gamerbill.kotlinarchitecturedemo.demolibrary.util

import java.util.*

open class DateTimeUtilImpl: DateTimeUtil {
    override fun getHour(): Int {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    }
}
