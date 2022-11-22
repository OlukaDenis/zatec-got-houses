package com.domain.usecases

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import com.domain.base.BaseFlowUseCase
import com.domain.dispacher.AppDispatcher
import com.domain.model.House
import com.domain.model.sealed.Resource
import com.domain.repository.LocalRepository
import com.domain.repository.RemoteRepository
import com.domain.repository.UtilRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.security.InvalidParameterException
import javax.inject.Inject

/**
 * Use case that fetches houses from the remote data source then saves to the local data source
 * Accepts the parameters passed from the user interaction
 * @property remote Remote data source
 * @property local Local data source
 * @property utilRepository utility helpers
 * @property dispatcher coroutine dispatcher
 * @constructor
 *
 */
class FetchMoreRemoteHousesUseCase @Inject constructor(
    private val dispatcher: AppDispatcher,
    private val remote: RemoteRepository,
    private val local: LocalRepository,
    private val utilRepository: UtilRepository
) : BaseFlowUseCase<FetchMoreRemoteHousesUseCase.Param, Resource<List<House>>>(dispatcher) {

    data class Param(val page: Long)

    /**
     * Collects the states of houses being fetched from the remote data source
     * Handles saving the remote houses to the local database
     * @param param
     * @return Flow of resource states
     */
    override fun run(param: Param?): Flow<Resource<List<House>>> = flow {
        emit(Resource.Loading)

        try {
            param?.let {
                val request = HashMap<String, Any>().apply {
                    this["page"] = it.page
                    this["pageSize"] = PAGE_SIZE
                }

                val result = remote.fetchHouses(request)

                result.map {
                    local.insertHouse(it)
                }

                emit(Resource.Success(result))
            } ?: throw InvalidParameterException()
        } catch (throwable: Throwable) {
            emit(Resource.Error(utilRepository.getNetworkError(throwable)))
        }
    }
}