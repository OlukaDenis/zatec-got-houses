package com.data.local.mediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.data.local.model.HouseEntity
import com.data.local.room.dao.HouseDao
import com.data.local.room.dao.RemoteKeyDao
import com.data.remote.remoteMappers.RemoteHouseMapper
import com.data.remote.services.ApiService
import com.domain.repository.LocalRepository
import com.domain.utils.Constants.NETWORK_PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HouseMediatorUseCase @Inject constructor(
    private val service: ApiService,
    private val localRepository: LocalRepository,
    private val remoteHouseMapper: RemoteHouseMapper,
    private val remoteKeyDao: RemoteKeyDao,
    private val houseDao: HouseDao
) {

    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(): Flow<PagingData<HouseEntity>> {
        val pagingSourceFactory = { houseDao.pagingSource() }

        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = pagingSourceFactory,
            remoteMediator = HouseRemoteMediator(
                service,
                localRepository,
                remoteKeyDao,
                remoteHouseMapper
            )
        ).flow
    }
}