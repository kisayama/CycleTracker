package com.example.cycletracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cycletracker.data.model.Cycles

@Dao
interface CyclesDAO {
    @Query("SELECT * FROM CycleData")
    suspend fun getAllCycles() : List<Cycles>
    //見つかるレコードは一つだけ　見つからなかったらNullを返す
    @Query("SELECT * FROM CycleData WHERE :id")
    suspend fun findCycleDataById(id: Long):Cycles?
    @Update
    suspend fun updateCycle(cycleData: Cycles)
    @Insert
    suspend fun insertCycle(cycleData: Cycles)
    @Delete
    suspend fun deleteCycle(cycleData: Cycles)

}