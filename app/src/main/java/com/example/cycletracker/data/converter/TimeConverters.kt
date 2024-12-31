package com.example.cycletracker.data.converter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.sql.Time
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date

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