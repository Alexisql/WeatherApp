package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.Weather
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("current") val current: CurrentDto,
    @SerializedName("forecast") val forecast: ForecastDto
)

fun WeatherDto.toDomain() =
    Weather(current.toDomain(), forecast.toDomain())