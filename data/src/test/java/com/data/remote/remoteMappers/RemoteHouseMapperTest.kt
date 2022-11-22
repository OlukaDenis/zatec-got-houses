package com.data.remote.remoteMappers

import com.data.utils.dummyRemoteHouse
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class RemoteHouseMapperTest {

    private lateinit var remoteHouseMapper: RemoteHouseMapper

    @Before
    fun setUp() {
        remoteHouseMapper = RemoteHouseMapper()
    }

    @Test
    fun `Test map remote house to domain house`() {
        // Given
        val remoteHouse = dummyRemoteHouse

        // When
        val house = remoteHouseMapper.toDomain(remoteHouse)

        // Then
        Truth.assertThat(house.name).isEqualTo(remoteHouse.name)
    }
}