package com.alexis.weatherapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexis.weatherapp.domain.repository.ILocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: ILocationRepository
) : ViewModel() {

    fun getLocations(query: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                locationRepository.getLocations(query)
            }
        }
    }
}