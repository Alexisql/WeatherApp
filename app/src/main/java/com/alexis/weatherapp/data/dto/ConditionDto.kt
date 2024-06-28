package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.domain.model.Condition
import com.google.gson.annotations.SerializedName

private const val PROTOCOL_HTTPS = "https:"

data class ConditionDto(
    @SerializedName("icon") val icon: String,
    @SerializedName("text") val text: String
)

fun ConditionDto.toDomain() =
    Condition(PROTOCOL_HTTPS.plus(icon), text)