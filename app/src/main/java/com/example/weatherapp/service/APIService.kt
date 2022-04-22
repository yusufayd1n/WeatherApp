package com.example.weatherapp.service

import com.example.weatherapp.model.ModelWeather
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIService {
    private val BASE_URL="https://api.openweathermap.org/"
    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(API::class.java)

    fun getDataService(cityName:String): Single<ModelWeather> {
        return api.getData(cityName)
    }
}