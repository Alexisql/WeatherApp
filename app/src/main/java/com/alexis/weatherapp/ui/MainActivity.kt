package com.alexis.weatherapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.alexis.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showSplash()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun showSplash() {
        installSplashScreen().setKeepOnScreenCondition { false }
    }

    private fun initUI() {
        binding.lifecycleOwner = this@MainActivity
        val navHost =
            supportFragmentManager.findFragmentById(binding.navHostFragmentContainer.id) as NavHostFragment
        navController = navHost.navController
    }
}