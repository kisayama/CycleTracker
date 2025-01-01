package com.example.cycletracker.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cycletracker.data.dao.CyclesDAO
import com.example.cycletracker.data.dao.RemaindersDAO
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {
    private lateinit var cyclesDAO:CyclesDAO
    private lateinit var remindersDAO: RemaindersDAO
    private lateinit var db:CycleDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, CycleDatabase::class.java
        ).build()
        cyclesDAO = db.cyclesDao()
        remindersDAO = db.remaindersDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
    @Test
    @Throws(Exception::class)
    suspend fun writeCycleAndReadInList(){
        val testUtil = TestUtil()
        //初期値でテストする
        val testData = testUtil.createCycle()
        cyclesDAO.insertCycle(testData)
    }
}