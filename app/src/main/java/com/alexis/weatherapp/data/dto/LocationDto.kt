package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.Location
import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("name") val name: String,
    @SerializedName("region") val region: String,
    @SerializedName("country") val country: String,
)

fun LocationDto.toDomain() =
    Location(name, region, country)
