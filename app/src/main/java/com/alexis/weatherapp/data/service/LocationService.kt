package com.alexis.weatherapp.data.service

import com.alexis.weatherapp.data.dto.LocationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationService {

    @GET("v1/search.json")
    suspend fun getLocations(
        @Query("key") key: String,
        @Query("q") query: String
    ): List<LocationDto>
}