package com.example.cycletracker.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cycletracker.data.dao.CyclesDAO
import com.example.cycletracker.data.dao.RemaindersDAO
import kotlinx.coroutines.runBlocking
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
    fun writeTableAndReadInList() = runBlocking{
        val cycleTestUtil = CycleTestUtil()
        //初期値でテストする
        val testData = cycleTestUtil.createCycle()
        cyclesDAO.insertCycle(testData)

        val allData = cyclesDAO.getAllCycles()

        allData.forEach {
            Log.d("AllCycleData","Cycle$it")
        }
        val remainderTestData = RemainderTestUtil().createRemainder()
        remindersDAO.insertRemainder(remainderTestData)
        val remainderAllData = remindersDAO.getAllRemainders()

        remainderAllData.forEach { it ->
            Log.d("AllRemainder","Remainder$it")
        }
    }

}