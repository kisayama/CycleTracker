package com.example.cycletracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cycletracker.data.converter.DateConverts
import com.example.cycletracker.data.converter.TimeConverters
import com.example.cycletracker.data.dao.CyclesDAO
import com.example.cycletracker.data.dao.RemaindersDAO
import com.example.cycletracker.data.model.Cycles
import com.example.cycletracker.data.model.Remainders

@Database(entities = [Cycles::class,Remainders::class],version = 1, exportSchema = false)
@TypeConverters(DateConverts::class, TimeConverters::class)
abstract class CycleDatabase : RoomDatabase(){
    abstract fun cyclesDao(): CyclesDAO

    abstract fun remaindersDao(): RemaindersDAO
}