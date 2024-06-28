package com.alexis.weatherapp.domain.builder

import com.alexis.weatherapp.domain.model.Location

class LocationBuilder {

    private val locationOne = Location(
        "Cucuta",
        "Norte de Santander",
        "Colombia"
    )
    private val locationTwo = Location(
        "Cucuyagua",
        "Copan",
        "Honduras"
    )
    private val locationThree = Location(
        "Cucunuba",
        "Cundinamarca",
        "Colombia"
    )

    fun build() = listOf(locationOne, locationTwo, locationThree)
}