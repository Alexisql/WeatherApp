package com.alexis.weatherapp.data.builder

import com.alexis.weatherapp.data.dto.ConditionDto

class ConditionDtoBuilder {

    private val condition = ConditionDto(
        "//cdn.weatherapi.com/weather/64x64/day/116.png",
        "Fog"
    )

    fun build() = condition
}