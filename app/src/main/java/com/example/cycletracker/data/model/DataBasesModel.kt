package com.example.cycletracker.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.Date

@Entity(tableName = "CycleData")
data class Cycles(
    @PrimaryKey(autoGenerate = true) val id:Long,
    @ColumnInfo(name = "startDay")
    val startDay: Date,
    @ColumnInfo(name = "endDay")
    val endDay: Date,
    @ColumnInfo(name = "during")
    //Dateは単位msなので引き算の結果を1日分のmsで割る
    val cycleLength: Int
)

@Entity(tableName = "Remainders",
    foreignKeys = [ForeignKey(
        entity = Cycles::class,
        parentColumns = ["id"],
        //parentColumnsとchildColumnsは同じ値を持つ　値を指定することで相互のアクセスが可能になる
        childColumns = ["eventId"],
        onDelete = ForeignKey.CASCADE //親が削除された時には対応するremaindersも削除する
    )
    ]
)
data class Remainders(
    @PrimaryKey(autoGenerate = true) val id :Long,
    val eventId:Long,
    val remindAt :Date,
    val remindHour : Time
)

