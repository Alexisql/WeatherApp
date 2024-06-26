package com.alexis.weatherapp.domain.repository

import com.alexis.weatherapp.domain.model.Location

interface ILocationRepository {
    suspend fun getLocations(query: String): Result<List<Location>>
}