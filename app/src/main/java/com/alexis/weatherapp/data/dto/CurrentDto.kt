package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.Current
import com.google.gson.annotations.SerializedName

data class CurrentDto(
    @SerializedName("condition") val condition: ConditionDto,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("temp_c") val temp: Double,
    @SerializedName("wind_kph") val wind: Double
)

fun CurrentDto.toDomain() =
    Current(condition.toDomain(), humidity, temp, wind)