package com.example.cycletracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cycletracker.model.CycleData

@Dao
interface CycleDao {
    @Query("SELECT * FROM CycleData")
    fun getAll() : List<CycleData>
    @Update
    suspend fun update(cycleData: CycleData)
    @Insert
    fun insert(cycleData:CycleData)
    @Delete
    fun delete(cycleData: CycleData)

}