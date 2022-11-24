package com.data.remote.impl


import com.data.remote.remoteMappers.RemoteHouseMapper
import com.data.remote.services.ApiService
import com.data.utils.BaseRemoteTest
import com.data.utils.apiServiceTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import java.net.HttpURLConnection

class RemoteRepositoryImplTest : BaseRemoteTest() {

    private lateinit var remoteHouseMapper: RemoteHouseMapper
    private lateinit var apiService: ApiService
    private lateinit var remoteRepository: RemoteRepositoryImpl

    @Before
    fun init() {
        super.setUp()
        remoteHouseMapper = RemoteHouseMapper()
        apiService = apiServiceTest(getMockWebServerUrl())
        remoteRepository = RemoteRepositoryImpl(apiService, remoteHouseMapper)
    }

    @Test
    fun `Fetch single house success`() = runBlocking {
        // Given
        mockNetworkResponseWithFileContent(
            "houses/single_house.json",
            HttpURLConnection.HTTP_OK
        )

        // When
        val result = remoteRepository.fetchSingleHouse(362)

        // Then
        Truth.assertThat(result).isNotNull()
        Truth.assertThat(result.name).isEqualTo("House Stark of Winterfell")
    }

    @Test
    fun `Fetch single house failure`() = runBlocking {
        // Given
       mockNetworkResponseWithCode(HttpURLConnection.HTTP_BAD_REQUEST)

        // When
        val result = kotlin.runCatching { remoteRepository.fetchSingleHouse(362) }

        // Then
        val error = result.exceptionOrNull()
        Truth.assertThat(error).isNotNull()
        Truth.assertThat(error).isInstanceOf(HttpException::class.java)
        val code = (error as HttpException).code()
        Truth.assertThat(code).isEqualTo(400)
    }

    @Test
    fun `Fetch houses list success`() = runBlocking {
        // Given
        mockNetworkResponseWithFileContent(
            "houses/houses.json",
            HttpURLConnection.HTTP_OK
        )
        val request = hashMapOf<String, Any>()

        // When
        val result = remoteRepository.fetchHouses(request)

        // Then
        Truth.assertThat(result).isNotNull()
        Truth.assertThat(result).isNotEmpty()
    }


    @Test
    fun `Fetch houses list failure`() = runBlocking {
        // Given
        mockNetworkResponseWithCode(HttpURLConnection.HTTP_BAD_GATEWAY)
        val request = hashMapOf<String, Any>()

        // When
        val result = kotlin.runCatching { remoteRepository.fetchHouses(request) }

        // Then
        val error = result.exceptionOrNull()
        Truth.assertThat(error).isNotNull()
        Truth.assertThat(error).isInstanceOf(HttpException::class.java)
        val code = (error as HttpException).code()
        Truth.assertThat(code).isEqualTo(502)
    }
}