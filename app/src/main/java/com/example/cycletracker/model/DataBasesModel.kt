package com.example.cycletracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.Date

@Entity(tableName = "CyclesData")
data class Cycles(
    // autoGenerateを有効にするため、初期値として0を設定。(初期値を設定しないとコンパイル時にエラーが発生するため)
    // autoGenerateが優先され、実際のIDは自動的に生成される。
    @PrimaryKey(autoGenerate = true) val id:Long= 0,
    @ColumnInfo(name = "startDay")
    val startDay: Date,
    @ColumnInfo(name = "endDay")
    val endDay: Date,
    @ColumnInfo(name = "cycleLength")
    //Dateは単位msなので引き算の結果を1日分のmsで割る
    val cycleLength: Int
)

@Entity(tableName = "RemaindersData",
    foreignKeys = [ForeignKey(
        entity = Cycles::class,
        parentColumns = ["id"],
        //parentColumnsとchildColumnsは同じ値を持つ　値を指定することで相互のアクセスが可能になる
        childColumns = ["cycleId"],
        onDelete = ForeignKey.CASCADE //親が削除された時には対応するremaindersも削除する
    )],
    indices = [Index(value = ["cycleId"])]//cycleIdにインデックスを作成
)
data class Remainders(
    @PrimaryKey(autoGenerate = true) val remainderId :Long= 0,
    val cycleId:Long,
    val remindAt :Date,
    val remindHour : Time = Time(21 * 60 * 60 * 1000) //初期値は21時
)

