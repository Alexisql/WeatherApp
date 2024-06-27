package com.alexis.weatherapp.domain.repository

import com.alexis.weatherapp.domain.model.Location
import com.alexis.weatherapp.domain.model.Weather

interface IWeatherRepository {
    suspend fun getLocations(query: String): Result<List<Location>>
    suspend fun getWeather(location: String, numberDays: Int): Result<Weather>
}