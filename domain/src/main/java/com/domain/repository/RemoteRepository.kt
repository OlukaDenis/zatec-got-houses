package com.domain.repository

import com.domain.model.*
import okhttp3.RequestBody

/**
 * Repository that handles remote CRUD operations
 */
interface RemoteRepository {

    /**
     * Fetches remote details of a single house
     *
     * @param id house id
     * @return house in details
     */
    suspend fun fetchSingleHouse(id: Long): House

    /**
     * Fetches remote list of houses
     *
     * @param request query parameters
     * @return list of houses
     */
    suspend fun fetchHouses(request: HashMap<String, Any>): List<House>

}