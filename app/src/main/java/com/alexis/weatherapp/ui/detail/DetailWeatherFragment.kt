package com.alexis.weatherapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexis.weatherapp.R
import com.alexis.weatherapp.databinding.FragmentDetailWeatherBinding
import com.alexis.weatherapp.domain.model.Weather
import com.alexis.weatherapp.ui.detail.adapter.ForecastDayAdapter
import com.alexis.weatherapp.ui.util.ResultState
import com.alexis.weatherapp.ui.util.extension.visibilityGone
import com.alexis.weatherapp.ui.util.extension.visibilityVisible
import com.alexis.weatherapp.ui.util.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailWeatherFragment :
    BaseFragment<FragmentDetailWeatherBinding>(R.layout.fragment_detail_weather) {

    private val weatherViewModel: DetailWeatherViewModel by activityViewModels()
    private val detailWeatherArgs by navArgs<DetailWeatherFragmentArgs>()
    private lateinit var forecastDayAdapter: ForecastDayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStateUI()
    }

    override fun onStart() {
        super.onStart()
        weatherViewModel.getWeather(detailWeatherArgs.location, 3)
    }

    override fun initUI() {
        initAdapter()
        initRecycler()
    }

    override fun initAdapter() {
        forecastDayAdapter = ForecastDayAdapter()
    }

    override fun initRecycler() {
        binding.rvForecastday.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = forecastDayAdapter
        }
    }

    private fun initStateUI() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                weatherViewModel.state.collect {
                    val progressBar = binding.pbDetailWeather
                    when (it) {
                        ResultState.Loading -> {
                            progressBar.visibilityVisible()
                        }

                        is ResultState.Success -> {
                            setView(it.data)
                        }

                        is ResultState.Failure -> {
                            Log.e("Error", it.exception.message!!)
                        }
                    }
                    if (it != ResultState.Loading) {
                        progressBar.visibilityGone()
                    }
                }
            }
        }
    }

    private fun setView(weather: Weather) {
        binding.apply {
            this.weather = weather
            ivBack.setOnClickListener { findNavController().popBackStack() }
        }
        forecastDayAdapter.updateList(weather.forecast.forecastDay)
    }

}