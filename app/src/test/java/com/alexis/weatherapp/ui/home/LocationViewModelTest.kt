package com.alexis.weatherapp.ui.home

import com.alexis.weatherapp.domain.builder.LocationBuilder
import com.alexis.weatherapp.domain.repository.IWeatherRepository
import com.alexis.weatherapp.ui.MainDispatcherRule
import com.alexis.weatherapp.ui.util.ResultState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LocationViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @MockK
    private lateinit var repositoryMockk: IWeatherRepository
    private lateinit var viewModel: LocationViewModel

    @Before
    fun initBefore() {
        MockKAnnotations.init(this)
        viewModel = LocationViewModel(
            repositoryMockk,
            mainDispatcherRule.testDispatcher
        )
    }

    @Test
    fun `get locations, validate mapping to the domain layer, successful`() =
        runTest {
            //Arrange
            val locationFakeDomain = LocationBuilder().build()
            val query = "cucu"
            coEvery { repositoryMockk.getLocations(query) } returns Result.success(
                locationFakeDomain
            )

            //Act
            viewModel.getLocations(query)

            //Assert
            assertEquals(ResultState.Success(locationFakeDomain), viewModel.state.value)
        }
}