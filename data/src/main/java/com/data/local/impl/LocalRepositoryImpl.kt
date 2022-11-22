package com.data.local.impl

import com.data.local.localMappers.*
import com.data.local.room.dao.*
import com.domain.model.*
import com.domain.repository.LocalRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val houseDao: HouseDao,
    private val localHouseMapper: LocalHouseMapper
) : LocalRepository {
    override suspend fun insertHouse(entity: House) {
        houseDao.insert(localHouseMapper.toLocal(entity))
    }

    override fun getHouses(): Flow<List<House>> {
        return houseDao.get().map { list ->
            list.map {
                localHouseMapper.toDomain(it)
            }
        }
    }

    override suspend fun clearHouses() {
        houseDao.clear()
    }

    override fun getHouseById(id: Long): Flow<House?> {
       return houseDao.getById(id).map {
           if (it == null) null else localHouseMapper.toDomain(it)
       }
    }

    override suspend fun updateHouse(entity: House) {
        houseDao.update(localHouseMapper.toLocal(entity))
    }

}