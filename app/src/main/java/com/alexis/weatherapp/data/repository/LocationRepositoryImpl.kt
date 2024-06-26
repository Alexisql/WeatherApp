package com.alexis.weatherapp.data.repository

import com.alexis.weatherapp.BuildConfig.API_KEY
import com.alexis.weatherapp.data.dto.toDomain
import com.alexis.weatherapp.data.service.LocationService
import com.alexis.weatherapp.domain.model.Location
import com.alexis.weatherapp.domain.repository.ILocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locatioService: LocationService
) : ILocationRepository {

    override suspend fun getLocations(query: String): Result<List<Location>> {
        return try {
            val response = locatioService.getLocations(API_KEY, query)
            Result.success(response.map { it.toDomain() })
        } catch (exception: Throwable) {
            Result.failure(exception)
        }
    }
}