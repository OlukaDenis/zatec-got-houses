package com.zatec.got_houses.presentation.houses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.data.local.mediators.HouseMediatorUseCase
import com.data.local.model.HouseEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HouseListViewModel @Inject constructor(
    private val houseMediatorUseCase: HouseMediatorUseCase
) : ViewModel() {

    val houses: Flow<PagingData<HouseEntity>> =
        houseMediatorUseCase().cachedIn(viewModelScope)
}