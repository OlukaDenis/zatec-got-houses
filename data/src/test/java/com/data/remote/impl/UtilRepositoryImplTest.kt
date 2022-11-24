package com.data.remote.impl

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import java.io.IOException

class UtilRepositoryImplTest {

    private lateinit var utilRepositoryImpl: UtilRepositoryImpl

    @Before
    fun setUp() {
        utilRepositoryImpl = UtilRepositoryImpl()
    }

    @Test
    fun `Extract readable remote IO Exception error`() {
        // Given
        val throwable = IOException()

        // When
        val error = utilRepositoryImpl.getNetworkError(throwable)

        // Then
        Truth.assertThat(error).isEqualTo("No internet access")
    }
}