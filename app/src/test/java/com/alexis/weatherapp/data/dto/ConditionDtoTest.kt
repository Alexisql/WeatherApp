package com.alexis.weatherapp.data.dto

import com.alexis.weatherapp.data.builder.ConditionDtoBuilder
import org.junit.Assert.*
import org.junit.Test

class ConditionDtoTest {

    @Test
    fun `to domain, validate https protocol addition in condition domain, successful`() {
        //Arrange
        val conditionDto = ConditionDtoBuilder().build()
        //Act
        val conditionDomain = conditionDto.toDomain()
        val iconHttps = "https://cdn.weatherapi.com/weather/64x64/day/116.png"
        //Assert
        assertEquals(iconHttps, conditionDomain.icon)
    }
}