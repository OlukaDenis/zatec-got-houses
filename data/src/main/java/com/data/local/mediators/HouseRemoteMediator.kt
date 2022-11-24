package com.data.local.mediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.data.local.model.HouseEntity
import com.data.local.model.RemoteKeyEntity
import com.data.local.room.dao.RemoteKeyDao
import com.data.remote.remoteMappers.RemoteHouseMapper
import com.data.remote.services.ApiService
import com.domain.repository.LocalRepository
import retrofit2.HttpException
import java.io.IOException


@ExperimentalPagingApi
class HouseRemoteMediator(
    private val service: ApiService,
    private val localRepository: LocalRepository,
    private val remoteKeyDao: RemoteKeyDao,
    private val remoteHouseMapper: RemoteHouseMapper
) : RemoteMediator<Int, HouseEntity>() {

    companion object {
        private const val DEFAULT_PAGE_INDEX = 1
    }

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, HouseEntity>
    ): MediatorResult {

        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    val remoteKey: RemoteKeyEntity? =  if (lastItem?.id != null) {
                        remoteKeyDao.getKeyById(lastItem.id)
                    } else null

                    if (remoteKey?.nextKey == null) {
                        MediatorResult.Success(endOfPaginationReached = true)
                    }

                    remoteKey?.nextKey ?: 1
                }
            }

            val request = hashMapOf<String, Any>().apply {
                this["page"] = page
                this["pageSize"] = state.config.pageSize
            }

            val response = service.fetchHouses(request)
            val isEndOfList = response.isEmpty()

            if (loadType == LoadType.REFRESH) {
                remoteKeyDao.clear()
                localRepository.clearHouses()
            }

            val prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1
            val nextKey = if (isEndOfList) null else page + 1

            val houses = response.map { remoteHouseMapper.toDomain(it)  }
            val keys = houses.map {
                RemoteKeyEntity(keyId = it.id, prevKey = prevKey, nextKey = nextKey)
            }

            remoteKeyDao.insertKeys(keys)
            houses.map {
                localRepository.insertHouse(it)
            }

            MediatorResult.Success(endOfPaginationReached = isEndOfList)
        } catch (exception: IOException) {
            MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            MediatorResult.Error(exception)
        }
    }
}