package com.example.cycletracker.data.repositoryImpl

import com.example.cycletracker.data.dao.RemainderRepository
import com.example.cycletracker.data.dao.RemaindersDAO
import com.example.cycletracker.data.model.Remainders

class RemainderRepositoryImpl(private val remaindersDAO: RemaindersDAO) :RemainderRepository{

    override suspend fun getAllRemainders(): List<Remainders> {
        return remaindersDAO.getAllRemainders()
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