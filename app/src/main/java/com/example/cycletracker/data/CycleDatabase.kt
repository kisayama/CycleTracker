package com.example.cycletracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [CycleDatabase::class],version = 1, exportSchema = false)
@TypeConverters(DateConverts::class)
abstract class CycleDatabase : RoomDatabase(){
    abstract fun cycleDatabase():CycleDatabase
}