package com.domain.usecases

import com.domain.base.BaseFlowUseCase
import com.domain.dispacher.AppDispatcher
import com.domain.model.House
import com.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Handles picking all houses from the local database
 * @property dispatcher
 * @property local
 */
class GetLocalHousesUseCase @Inject constructor(
    private val dispatcher: AppDispatcher,
    private val local: LocalRepository
) : BaseFlowUseCase<Unit, List<House>>(dispatcher) {

    override fun run(param: Unit?): Flow<List<House>> {
        return local.getHouses()
    }

}