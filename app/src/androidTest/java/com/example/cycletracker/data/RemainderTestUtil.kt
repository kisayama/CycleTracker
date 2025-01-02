package com.example.cycletracker.data

import com.example.cycletracker.data.model.Remainders
import java.util.Date

class RemainderTestUtil {

    private val testCycleId :Long = 1

    // 今日の一ヶ月後をリマインド日付として設定する
    private val testReminedAt:Date = Date(Date().time + (30 * 24 * 60 * 60 * 1000))

    fun createRemainder(cycleId:Long = testCycleId,remindAt:Date = testReminedAt): Remainders {
        return Remainders(cycleId = cycleId, remindAt = remindAt)
    }
}