package com.alexis.weatherapp.data.repository

import com.alexis.weatherapp.BuildConfig.API_KEY
import com.alexis.weatherapp.data.dto.toDomain
import com.alexis.weatherapp.data.service.WeatherService
import com.alexis.weatherapp.domain.model.Location
import com.alexis.weatherapp.domain.model.Weather
import com.alexis.weatherapp.domain.repository.IWeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService
) : IWeatherRepository {

    override suspend fun getLocations(query: String): Result<List<Location>> {
        return try {
            val response = weatherService.getLocations(API_KEY, query)
            Result.success(response.map { it.toDomain() })
        } catch (exception: Throwable) {
            Result.failure(exception)
        }
    }

    override suspend fun getWeather(location: String, numberDays: Int): Result<Weather> {
        return try {
            val response = weatherService.getWeather(API_KEY, location, numberDays)
            Result.success(response.toDomain())
        } catch (exception: Throwable) {
            Result.failure(exception)
        }
    }
}