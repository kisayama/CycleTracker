package com.example.cycletracker.data

import com.example.cycletracker.data.model.Cycles
import java.util.Date

class TestUtil {
    val startDate = Date()
    val endDate = Date(startDate.time + (2 * 24 * 60 * 60 * 1000))  // 2日後

    fun createCycle(id: Long = 1, startDay:Date =startDate,endDay:Date = endDate): Cycles {
        val cycleLengthMills = endDate.time - startDate.time  // ミリ秒の差
        val cycleLength = (cycleLengthMills / (1000 * 60 * 60 * 24)).toInt()  // ミリ秒を日数に変換
     return Cycles(id = id, startDay = startDay,endDay = endDay, cycleLength = cycleLength)
    }
}