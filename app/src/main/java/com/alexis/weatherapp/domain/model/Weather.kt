package com.alexis.weatherapp.domain.model

data class Weather(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)