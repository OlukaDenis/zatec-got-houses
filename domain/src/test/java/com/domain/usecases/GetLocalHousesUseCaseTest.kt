package com.domain.usecases

import com.domain.dispacher.AppDispatcher
import com.domain.repository.FakeLocalRepository
import com.domain.utils.getDummyHouses
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Test

class GetLocalHousesUseCaseTest {

    private val dispatcher: AppDispatcher = mockk()
    private val fakeLocalRepository: FakeLocalRepository = FakeLocalRepository()
    private lateinit var getLocalHousesUseCase: GetLocalHousesUseCase

    @Before
    fun setUp() {
        getLocalHousesUseCase = GetLocalHousesUseCase(dispatcher, fakeLocalRepository)
    }

    @Test
    fun `Fetch local houses list`() = runBlocking {
        // Given
        coEvery { dispatcher.io } returns Dispatchers.Unconfined
        getDummyHouses().forEach {
            fakeLocalRepository.insertHouse(it)
        }

        // When
        val result = getLocalHousesUseCase().first()

        // Then
        assertThat(result).isNotEmpty()
        assertThat(result).isNotNull()
    }
}