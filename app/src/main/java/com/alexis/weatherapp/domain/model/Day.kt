package com.alexis.weatherapp.domain.model

data class Day(
    val humidity: Int,
    val condition: Condition,
    val tempMax: Double,
    val tempMin: Double
)