package com.example.weatherapp.service

import com.example.weatherapp.model.ModelWeather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    //https://api.openweathermap.org/data/2.5/weather?q=trabzon&appid=fadfe3bd9c688cd82830ca2cdceaeb09
    @GET("data/2.5/weather?&units=metric&appid=fadfe3bd9c688cd82830ca2cdceaeb09")
    fun getData(
        @Query("q") cityName:String
    ):Single<ModelWeather>


}