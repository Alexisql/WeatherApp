package com.alexis.weatherapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexis.weatherapp.domain.model.Weather
import com.alexis.weatherapp.domain.repository.IWeatherRepository
import com.alexis.weatherapp.ui.util.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailWeatherViewModel @Inject constructor(
    private val weatherRepository: IWeatherRepository,
    private val dispatcherIO: CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow<ResultState<Weather>>(ResultState.Loading)
    val state: StateFlow<ResultState<Weather>> = _state

    fun getWeather(location: String, numberDays: Int) {
        viewModelScope.launch {
            withContext(dispatcherIO) {
                val weather = weatherRepository.getWeather(location, numberDays)
                weather
                    .onSuccess { _state.value = ResultState.Success(it) }
                    .onFailure { _state.value = ResultState.Failure(it) }
            }
        }
    }
}