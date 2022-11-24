package com.domain.repository

import com.domain.model.House
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Class that contains fake Local repository methods
 *
 */
class FakeLocalRepository : LocalRepository {
    private val houses = mutableListOf<House>()

    override suspend fun insertHouse(entity: House) {
        houses.add(entity)
    }

    override fun getHouses(): Flow<List<House>> {
        return flow {
            emit(houses)
        }
    }

    override suspend fun clearHouses() {
        houses.clear()
    }

    override fun getHouseById(id: Long): Flow<House?> {
        return flow {
            emit(houses.find { it.id == id })
        }
    }

    override suspend fun updateHouse(entity: House) {
        val position = houses.indexOf(houses.find { it.id == entity.id })
        houses.add(position, entity)
    }
}