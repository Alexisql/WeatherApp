package com.alexis.weatherapp.data.di

import com.alexis.weatherapp.BuildConfig.BASE_URL
import com.alexis.weatherapp.data.repository.WeatherRepositoryImpl
import com.alexis.weatherapp.data.service.WeatherService
import com.alexis.weatherapp.domain.repository.IWeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun interceptorOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun locationService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Singleton
    @Provides
    fun locationRepository(weatherService: WeatherService): IWeatherRepository {
        return WeatherRepositoryImpl(weatherService)
    }
}