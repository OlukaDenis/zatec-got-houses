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
        Truth.assertThat(house.ancestralWeapons).isEqualTo(remoteHouse.ancestralWeapons)
        Truth.assertThat(house.heir).isEqualTo(remoteHouse.heir)
        Truth.assertThat(house.coatOfArms).isEqualTo(remoteHouse.coatOfArms)
        Truth.assertThat(house.cadetBranches).isEqualTo(remoteHouse.cadetBranches)
        Truth.assertThat(house.currentLord).isEqualTo(remoteHouse.currentLord)
        Truth.assertThat(house.diedOut).isEqualTo(remoteHouse.diedOut)
        Truth.assertThat(house.founded).isEqualTo(remoteHouse.founded)
        Truth.assertThat(house.founder).isEqualTo(remoteHouse.founder)
    }
}