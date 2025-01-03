package com.example.cycletracker.database.converter

import androidx.room.TypeConverter
import java.util.Date

class DateConverts {
    @TypeConverter
    fun fromTimestamp(value:Long?):Date? {
        return value?.let { Date(it) }
    }
    @TypeConverter
    fun dateToTimestamp(date:Date?): Long? {
        return date?.time
    }
}