package com.alexis.weatherapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexis.weatherapp.R
import com.alexis.weatherapp.databinding.FragmentHomeBinding
import com.alexis.weatherapp.domain.model.Location
import com.alexis.weatherapp.ui.home.adapter.LocationAdapter
import com.alexis.weatherapp.ui.util.ResultState
import com.alexis.weatherapp.ui.util.fragment.BaseFragment
import com.alexis.weatherapp.ui.util.extension.visibilityGone
import com.alexis.weatherapp.ui.util.extension.visibilityVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val locationViewModel: LocationViewModel by activityViewModels()
    private lateinit var locationAdapter: LocationAdapter

    override fun initUI() {
        initAdapter()
        initRecycler()
        initListener()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStateUI()
    }

    private fun initStateUI() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                locationViewModel.state.collect {
                    val progressBar = binding.pbWeather
                    when (it) {
                        ResultState.Loading -> {
                            progressBar.visibilityVisible()
                            binding.rvWeather.visibilityGone()
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

    private fun setView(listLocation: List<Location>) {
        locationAdapter.updateList(listLocation)
        binding.rvWeather.visibilityVisible()
    }

    private fun initAdapter() {
        locationAdapter = LocationAdapter(onItemClickListener = {
            findNavController().navigate(
                HomeFragmentDirections.actionToDetailWeatherFragment(it)
            )
        })
    }

    private fun initRecycler() {
        binding.rvWeather.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = locationAdapter
        }
    }

    private fun initListener() {
        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty()) {
                    locationViewModel.getLocations(newText)
                } else {
                    locationAdapter.updateList(listOf())
                }
                return true
            }
        })
    }

}