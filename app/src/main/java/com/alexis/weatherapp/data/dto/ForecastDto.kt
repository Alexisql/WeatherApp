package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.Forecast
import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday") val forecastDay: List<ForecastDayDto>
)

fun ForecastDto.toDomain() =
    Forecast(forecastDay.map { it.toDomain() })