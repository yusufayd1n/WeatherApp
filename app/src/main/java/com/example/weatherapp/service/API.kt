package com.example.weatherapp.service

import com.example.weatherapp.model.ModelWeather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("data/2.5/weather?&units=metric&appid=API_KEY")
    fun getData(
        @Query("q") cityName:String
    ):Single<ModelWeather>


}