package com.alexis.weatherapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.alexis.weatherapp.R
import com.alexis.weatherapp.databinding.FragmentDetailWeatherBinding
import com.alexis.weatherapp.ui.util.ResultState
import com.alexis.weatherapp.ui.util.fragment.BaseFragment
import com.alexis.weatherapp.ui.util.visibilityGone
import com.alexis.weatherapp.ui.util.visibilityVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailWeatherFragment :
    BaseFragment<FragmentDetailWeatherBinding>(R.layout.fragment_detail_weather) {

    private val weatherViewModel: DetailWeatherViewModel by activityViewModels()
    private val detailWeatherArgs by navArgs<DetailWeatherFragmentArgs>()

    override fun initUI() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStateUI()
    }

    override fun onStart() {
        super.onStart()
        weatherViewModel.getWeather(detailWeatherArgs.location, 3)
    }

    private fun initStateUI() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                weatherViewModel.state.collect {
                    val progressBar = binding.pbWeather
                    when (it) {
                        ResultState.Loading -> {
                            progressBar.visibilityVisible()
                        }

                        is ResultState.Success -> {
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

}