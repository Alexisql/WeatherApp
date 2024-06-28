package com.alexis.weatherapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexis.weatherapp.domain.model.Location
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
class LocationViewModel @Inject constructor(
    private val weatherRepository: IWeatherRepository,
    private val dispatcherIO: CoroutineDispatcher
) : ViewModel() {

    private val _state =
        MutableStateFlow<ResultState<List<Location>>>(ResultState.Success(listOf()))
    val state: StateFlow<ResultState<List<Location>>> = _state

    fun getLocations(query: String) {
        viewModelScope.launch {
            withContext(dispatcherIO) {
                _state.value = ResultState.Loading
                val locations = weatherRepository.getLocations(query)
                locations
                    .onSuccess { _state.value = ResultState.Success(it) }
                    .onFailure { _state.value = ResultState.Failure(it) }
            }
        }
    }
}