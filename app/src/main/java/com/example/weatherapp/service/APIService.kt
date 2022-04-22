package com.example.weatherapp.service

import com.example.weatherapp.model.ModelWeather
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIService {
    ////https://api.openweathermap.org/data/2.5/weather?q=izmir&appid=fadfe3bd9c688cd82830ca2cdceaeb09
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