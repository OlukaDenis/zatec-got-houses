package com.domain.usecases

import com.domain.dispacher.AppDispatcher
import com.domain.repository.FakeLocalRepository
import com.domain.utils.dummyHouse
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.security.InvalidParameterException

class GetLocalHouseByIdUseCaseTest {

    private val dispatcher: AppDispatcher = mockk()
    private val fakeLocalRepository: FakeLocalRepository = FakeLocalRepository()
    private lateinit var getLocalHouseByIdUseCase:  GetLocalHouseByIdUseCase

    @Before
    fun setUp() {
        getLocalHouseByIdUseCase = GetLocalHouseByIdUseCase(dispatcher, fakeLocalRepository)
    }

    @Test
    fun `Fetch a single local house by ID success`() = runBlocking {
        // Given
        coEvery { dispatcher.io } returns Dispatchers.Unconfined
        fakeLocalRepository.insertHouse(dummyHouse)
        val param = GetLocalHouseByIdUseCase.Param(houseId = 10L)

        // When
        val result = getLocalHouseByIdUseCase(param)

        // Then
        result.collect {
            Truth.assertThat(it).isNotNull()
            Truth.assertThat(it?.name).isEqualTo("House of Denis")
        }
    }

    @Test
    fun `Fetch a single local house by ID failure`(): Unit = runBlocking {
        // Given
        coEvery { dispatcher.io } returns Dispatchers.Unconfined
        fakeLocalRepository.insertHouse(dummyHouse)

        // When
        try {
            getLocalHouseByIdUseCase().first()
        } catch (e: Exception) {
            Truth.assertThat(e).isNotNull()
            Truth.assertThat(e).isInstanceOf(InvalidParameterException::class.java)
        }


        // Then
    }
}