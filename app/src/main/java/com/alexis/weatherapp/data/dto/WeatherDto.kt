package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.Weather
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("location") val location: LocationDto,
    @SerializedName("current") val current: CurrentDto,
    @SerializedName("forecast") val forecast: ForecastDto
)

fun WeatherDto.toDomain() =
    Weather(location.toDomain(), current.toDomain(), forecast.toDomain())