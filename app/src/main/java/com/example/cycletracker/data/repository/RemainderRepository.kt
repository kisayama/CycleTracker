package com.example.cycletracker.data.dao

import com.example.cycletracker.data.model.Remainders

interface RemainderRepository {
    suspend fun getAllRemainders():List<Remainders>
    suspend fun updateRemainder(remainderData: Remainders)
    suspend fun insertRemainder(remainderData: Remainders)
    suspend fun deleteRemainder(remaindersData: Remainders)
}