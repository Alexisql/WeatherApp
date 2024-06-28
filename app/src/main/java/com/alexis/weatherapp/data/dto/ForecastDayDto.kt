package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.ForecastDay
import com.google.gson.annotations.SerializedName

data class ForecastDayDto(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: DayDto
)

fun ForecastDayDto.toDomain() =
    ForecastDay(date, day.toDomain())