package com.alexis.weatherapp.data.service

import com.alexis.weatherapp.data.dto.LocationDto
import com.alexis.weatherapp.data.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("v1/search.json")
    suspend fun getLocations(
        @Query("key") key: String,
        @Query("q") query: String
    ): List<LocationDto>

    @GET("v1/forecast.json")
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("days") numberDays: Int,
    ): WeatherDto
}