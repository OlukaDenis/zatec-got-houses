package com.zatec.got_houses.presentation.house_detail

import androidx.lifecycle.SavedStateHandle
import com.data.local.localMappers.LocalHouseMapper
import com.domain.usecases.GetLocalHouseByIdUseCase
import com.google.common.truth.Truth
import com.zatec.got_houses.utils.dummyHouse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class HouseDetailViewModelTest {

    private val  getLocalHouseByIdUseCase: GetLocalHouseByIdUseCase = mockk()
    private lateinit var houseDetailViewModel: HouseDetailViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)

        val savedState = SavedStateHandle(mapOf("houseId" to 90847903L))
        houseDetailViewModel = HouseDetailViewModel(getLocalHouseByIdUseCase, savedState)
    }


    @Test
    fun test_pick_selected_house() = runBlocking {
        // Given
        val houseFlow = flow { emit(dummyHouse) }
        val param = GetLocalHouseByIdUseCase.Param(houseId = 90847903L)
        coEvery { getLocalHouseByIdUseCase(param) } returns houseFlow


        // When
        houseDetailViewModel.getSelectedHouse()

        // Then
        coVerify { getLocalHouseByIdUseCase(param) }
        Truth.assertThat(houseDetailViewModel.house.value).isNotNull()
    }
}