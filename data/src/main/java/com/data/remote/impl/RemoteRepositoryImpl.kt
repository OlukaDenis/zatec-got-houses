package com.data.remote.impl

import com.data.remote.remoteMappers.RemoteHouseMapper
import com.data.remote.services.ApiService
import com.domain.model.House
import com.domain.repository.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val remoteHouseMapper: RemoteHouseMapper
) : RemoteRepository {

    override suspend fun fetchSingleHouse(id: Long): House {
        return try {
            apiService.fetchSingleUser(id)
        } catch (throwable: Throwable) {
            throw throwable
        }
    }

    override suspend fun fetchHouses(request: HashMap<String, Any>): List<House> {
        return try {
            val response = apiService.fetchHouses(request)
            response.map { remoteHouseMapper.toDomain(it) }
        } catch (throwable: Throwable) {
            throw throwable
        }
    }

}

