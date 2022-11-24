package com.data.remote.services

import com.data.remote.model.*
import com.domain.model.House
import retrofit2.http.*

interface ApiService {

    @GET("houses")
    suspend fun fetchHouses(@QueryMap request: HashMap<String, Any>): List<RemoteHouse>

    @GET("houses/{id}")
    suspend fun fetchSingleUser(@Path("id") id: Long): House
}