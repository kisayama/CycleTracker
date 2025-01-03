package com.example.cycletracker.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cycletracker.model.Remainders

@Dao
interface RemaindersDAO {
    @Query("SELECT* FROM RemaindersData" )
    suspend fun getAllRemainders():List<Remainders>
    @Query("SELECT * FROM RemaindersData WHERE remainderId = :remainderId")
    //見つかるレコードは一つだけ　見つからなかったらNullを返す
    suspend fun findRemaindersByRemainderId(remainderId:Long): Remainders?
    @Query("SELECT * FROM RemaindersData WHERE cycleId = :cycleId")
    suspend fun findRemaindersByCycleId(cycleId:Long): Remainders?
    @Update
    suspend fun updateRemainder(remaindersData: Remainders)
    @Insert
    suspend fun insertRemainder(remaindersData: Remainders)
    @Delete
    suspend fun deleteRemainder(remaindersData: Remainders)
}