package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.Condition
import com.google.gson.annotations.SerializedName

data class ConditionDto(
    @SerializedName("icon") val icon: String,
    @SerializedName("text") val text: String
)

fun ConditionDto.toDomain() =
    Condition(icon.replace("//","https://"), text)