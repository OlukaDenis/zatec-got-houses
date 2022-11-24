package com.data.local.impl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.data.local.di.DatabaseModule
import com.data.local.localMappers.LocalHouseMapper
import com.data.local.room.dao.HouseDao
import com.data.local.utils.getRandomNumber
import com.data.utils.dummyHouse
import com.data.utils.getDummyHouses
import com.domain.model.House
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(DatabaseModule::class)
class LocalRepositoryImplTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var houseDao: HouseDao

    @Inject
    lateinit var localHouseMapper: LocalHouseMapper

    private lateinit var localRepository: LocalRepositoryImpl

    @Before
    fun setUp() {
        hiltRule.inject()

        localRepository = LocalRepositoryImpl(houseDao, localHouseMapper)
    }

    @Test
    fun test_insertHouse() = runBlocking {
        // Given
        localRepository.insertHouse(dummyHouse)

        // When
        val savedHouse = localRepository.getHouseById(dummyHouse.id).first()

        // Then
        Truth.assertThat(savedHouse).isNotNull()
        Truth.assertThat(savedHouse?.name).isEqualTo(dummyHouse.name)
    }


    @Test
    fun test_getHouses() = runBlocking {
        // Given
        getDummyHouses().forEach {
            localRepository.insertHouse(it)
        }

        // When
        val houses = localRepository.getHouses().first()

        // Then
        Truth.assertThat(houses).isNotNull()
        Truth.assertThat(houses).isNotEmpty()
    }

    @Test
    fun test_updateHouse(): Unit = runBlocking {

        // Given
        localRepository.insertHouse(dummyHouse)


        // When
        val savedUser = localRepository.getHouseById(dummyHouse.id).first()
        savedUser?.let {
            val newUser = House(
                it.id,
                emptyList(),
                emptyList(),
                "",
                "",
                "",
                "",
                "Denis Updated",
                "",
                "House of Denis",
                "",
                "",
                emptyList(),
                emptyList(),
                emptyList(),
                "",
                "",
                "",
                ""
            )

            localRepository.updateHouse(newUser)

            val updatedUser = localRepository.getHouseById(newUser.id).first()

            // Then
            Truth.assertThat(updatedUser?.name).isEqualTo(savedUser.name)

        }

    }


    @Test
    fun test_clearHouses() = runBlocking {
        // Given
        getDummyHouses().forEach {
            localRepository.insertHouse(it)
        }

        // When
        localRepository.clearHouses()
        val houses = localRepository.getHouses().first()

        // Then
        Truth.assertThat(houses).isEmpty()
    }


}