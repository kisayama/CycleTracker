package com.example.cycletracker.database.repositoryImpl

import com.example.cycletracker.database.dao.CyclesDAO
import com.example.cycletracker.model.Cycles
import com.example.cycletracker.database.repository.CyclesRepository

class CyclesRepositoryImpl(private val cyclesDao: CyclesDAO): CyclesRepository {
    override suspend fun getAllCycles(): List<Cycles> {
        return cyclesDao.getAllCycles()
    }

    override suspend fun findCycleDataById(id:Long): Cycles? {
        return cyclesDao.findCycleDataById(id)
    }

    override suspend fun updateCycle(cycleData: Cycles) {
        cyclesDao.updateCycle(cycleData)
    }

    override suspend fun insertCycle(cycleData: Cycles) {
        cyclesDao.insertCycle(cycleData)
    }

    override suspend fun deleteCycle(cycleData: Cycles) {
        cyclesDao.deleteCycle(cycleData)
    }
}