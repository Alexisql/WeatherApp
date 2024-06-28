package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.Day
import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("avghumidity") val humidity: Int,
    @SerializedName("condition") val condition: ConditionDto,
    @SerializedName("maxtemp_c") val tempMax: Double,
    @SerializedName("mintemp_c") val tempMin: Double
)

fun DayDto.toDomain() =
    Day(humidity, condition.toDomain(), tempMax, tempMin)