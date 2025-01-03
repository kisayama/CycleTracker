package com.example.cycletracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cycletracker.database.converter.DateConverts
import com.example.cycletracker.database.converter.TimeConverters
import com.example.cycletracker.database.dao.CyclesDAO
import com.example.cycletracker.database.dao.RemaindersDAO
import com.example.cycletracker.model.Cycles
import com.example.cycletracker.model.Remainders

@Database(entities = [Cycles::class, Remainders::class],version = 1, exportSchema = false)
@TypeConverters(DateConverts::class, TimeConverters::class)
abstract class CycleDatabase : RoomDatabase(){
    abstract fun cyclesDao(): CyclesDAO

    abstract fun remaindersDao(): RemaindersDAO
}