package com.example.cycletracker.database.repositoryImpl

import com.example.cycletracker.data.dao.RemainderRepository
import com.example.cycletracker.database.dao.RemaindersDAO
import com.example.cycletracker.model.Remainders

class RemainderRepositoryImpl(private val remaindersDAO: RemaindersDAO) :RemainderRepository{
    override suspend fun getAllRemainders(): List<Remainders> {
        return remaindersDAO.getAllRemainders()
    }
    override suspend fun findRemaindersByCycleId(cycleId:Long): Remainders? {
        return remaindersDAO.findRemaindersByCycleId(cycleId)
    }
    override suspend fun findRemaindersByRemainderId(remainderId: Long): Remainders? {
        return remaindersDAO.findRemaindersByRemainderId(remainderId)
    }
    override suspend fun updateRemainder(remainderData: Remainders) {
        remaindersDAO.updateRemainder(remainderData)
    }

    override suspend fun insertRemainder(remainderData: Remainders) {
        remaindersDAO.insertRemainder(remainderData)
    }

    override suspend fun deleteRemainder(remaindersData: Remainders) {
        remaindersDAO.deleteRemainder(remaindersData)
    }
}