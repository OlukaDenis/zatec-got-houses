package com.zatec.got_houses.presentation.house_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.local.localMappers.LocalHouseMapper
import com.data.local.model.HouseEntity
import com.domain.model.House
import com.domain.usecases.GetLocalHouseByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HouseDetailViewModel @Inject constructor(
    private val localHouseMapper: LocalHouseMapper,
    private val getLocalHouseByIdUseCase: GetLocalHouseByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _house = mutableStateOf(
        HouseDetailState()
    )
    val house: State<HouseDetailState> = _house
    private var currentHouseId: Long? = null

    init {
        savedStateHandle.get<Long>("houseId")?.let { houseId ->
            Timber.d("Got houseId: $houseId")
            if (houseId != -1L) {
                viewModelScope.launch {
                    getLocalHouseByIdUseCase(GetLocalHouseByIdUseCase.Param(houseId = houseId)).also { houseFlow ->
                        houseFlow.collect {
                            it?.let { hse ->
                                currentHouseId = hse.id
                                _house.value = house.value.copy(
                                    house = hse
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun domainHouse(entity: HouseEntity) = localHouseMapper.toDomain(entity)
}