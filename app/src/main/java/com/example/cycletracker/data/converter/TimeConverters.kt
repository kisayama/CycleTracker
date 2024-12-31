package com.example.cycletracker.data.converter

import androidx.room.TypeConverter
import java.sql.Time

class TimeConverters {

    @TypeConverter
    fun fromTime(time: Time?):Long? {
        return time?.time//UNIXタイムスタンプを返す
    }

    @TypeConverter
    fun toTime(time:Long?):Time? {
        return if (time == null)null else Time(time)
    }

}