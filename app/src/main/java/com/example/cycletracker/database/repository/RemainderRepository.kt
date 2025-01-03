package com.example.cycletracker.data.dao

import com.example.cycletracker.model.Remainders

interface RemainderRepository {
    suspend fun getAllRemainders():List<Remainders>
    suspend fun findRemaindersByCycleId(cycleId:Long): Remainders?
    suspend fun findRemaindersByRemainderId(remainderId: Long): Remainders?
    suspend fun updateRemainder(remainderData: Remainders)
    suspend fun insertRemainder(remainderData: Remainders)
    suspend fun deleteRemainder(remaindersData: Remainders)
}