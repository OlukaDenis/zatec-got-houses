package com.domain.usecases

import com.domain.dispacher.AppDispatcher
import com.domain.model.sealed.Resource
import com.domain.repository.FakeLocalRepository
import com.domain.repository.RemoteRepository
import com.domain.repository.UtilRepository
import com.domain.utils.getDummyHouses
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.io.IOException

class FetchMoreRemoteHousesUseCaseTest {

    private val localRepository = FakeLocalRepository()
    private val remoteRepository: RemoteRepository = mockk()
    private val dispatcher: AppDispatcher = mockk()
    private val utilRepository: UtilRepository = mockk()

    private lateinit var fetchMoreRemoteHousesUseCase: FetchMoreRemoteHousesUseCase

    @Before
    fun setUp() {
        fetchMoreRemoteHousesUseCase = FetchMoreRemoteHousesUseCase(
            dispatcher,
            remoteRepository,
            localRepository,
            utilRepository
        )
    }

    @Test
    fun `Fetch more remote house list success`() = runBlocking {
        // Given
        coEvery { dispatcher.io } returns Dispatchers.Unconfined
        coEvery { remoteRepository.fetchHouses(any()) } returns getDummyHouses()
        val param = FetchMoreRemoteHousesUseCase.Param(page = 1)

        // When
        val result = fetchMoreRemoteHousesUseCase(param)

        // Then
        result.collect {
            when(it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    coVerify { remoteRepository.fetchHouses(any()) }
                    assertThat(it.data).isNotNull()

                    assertThat(localRepository.getHouses().first()).isNotEmpty()
                }
                is Resource.Error -> {
                    assertThat(it.exception).isNull()
                }
            }
        }
    }

    @Test
    fun `Fetch more remote house list failure`() = runBlocking {
        // Given
        coEvery { dispatcher.io } returns Dispatchers.Unconfined
        coEvery { remoteRepository.fetchHouses(any()) } throws IOException()
        coEvery { utilRepository.getNetworkError(any()) } returns "IO Exception"
        val param = FetchMoreRemoteHousesUseCase.Param(page = 1)

        // When
        val result = fetchMoreRemoteHousesUseCase(param)

        // Then
        result.collect {
            when(it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    assertThat(it.data).isNull()
                }
                is Resource.Error -> {
                    assertThat(it.exception).isEqualTo("IO Exception")
                }
            }
        }
    }
}