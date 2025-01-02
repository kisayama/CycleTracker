package com.example.cycletracker.data.repository

import com.example.cycletracker.data.model.Cycles

interface CyclesRepository {
    suspend fun getAllCycles():List<Cycles>
    suspend fun findCycleDataById(id:Long):Cycles?
    suspend fun updateCycle(cycleData:Cycles)
    suspend fun insertCycle(cycleData: Cycles)
    suspend fun deleteCycle(cycleData:Cycles)
}