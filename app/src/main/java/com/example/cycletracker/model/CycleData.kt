package com.example.cycletracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "CycleData")
data class CycleData(
    @PrimaryKey val id:String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "startDay")
    val startDay: Date,
    @ColumnInfo(name = "endDay")
    val endDay: Date,
    @ColumnInfo(name = "during")
    //Dateは単位msなので引き算の結果を1日分のmsで割る
    val during: Int = ((endDay.time - startDay.time) /(1000 * 60 *60 *24) ).toInt()
)
