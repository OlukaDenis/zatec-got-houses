package com.domain.usecases

import com.domain.base.BaseFlowUseCase
import com.domain.dispacher.AppDispatcher
import com.domain.model.House
import com.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import java.security.InvalidParameterException
import javax.inject.Inject

/**
 * Handles picking a single house from the local database given an ID
 *
 * @property dispatcher
 * @property local
 */
class GetLocalHouseByIdUseCase @Inject constructor(
    private val dispatcher: AppDispatcher,
    private val local: LocalRepository
) : BaseFlowUseCase<GetLocalHouseByIdUseCase.Param, House?>(dispatcher) {

    data class Param(val houseId: Long)

    /**
     * Picks a single house from local datasource
     *
     * @param param parameter containing houseId
     * @return Coroutine flow of house
     */
    override fun run(param: Param?): Flow<House?> {
        return param?.let {
            local.getHouseById(it.houseId)
        } ?: throw InvalidParameterException()
    }
}