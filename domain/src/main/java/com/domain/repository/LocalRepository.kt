package com.domain.repository

import com.domain.model.*
import kotlinx.coroutines.flow.Flow

/**
 * Repository that handles local CRUD operations
 */
interface LocalRepository {

    /**
     * Saves the house to the local database
     * @param entity house
     */
    suspend fun insertHouse(entity: House)

    /**
     * Picks all houses in the local database
     * @return list of houses
     */
    fun getHouses(): Flow<List<House>>

    /**
     * Clears all houses in the local database
     */
    suspend fun clearHouses()

    /**
     * Gets a house by ID from the local database
     * @param id
     * @return
     */
    fun getHouseById(id: Long): Flow<House?>

    /**
     * Updates a house in the local database
     * @param entity
     */
    suspend fun updateHouse(entity: House)
}