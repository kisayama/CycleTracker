package com.example.cycletracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cycletracker.data.model.Remainders

@Dao
interface RemaindersDAO {
    @Query("SELECT* FROM Remainders" )
    suspend fun getAllRemainders():List<Remainders>
    @Query("SELECT * FROM Remainders WHERE remainderId = :remainderId")
    //見つかるレコードは一つだけ　見つからなかったらNullを返す
    suspend fun findRemaindersByRemainderId(remainderId:Long):Remainders?
    @Query("SELECT * FROM Remainders WHERE cycleId = :cycleId")
    suspend fun findRemaindersByCycleId(cycleId:Long):Remainders?
    @Update
    suspend fun updateRemainder(remaindersData: Remainders)
    @Insert
    suspend fun insertRemainder(remaindersData: Remainders)
    @Delete
    suspend fun deleteRemainder(remaindersData: Remainders)
}