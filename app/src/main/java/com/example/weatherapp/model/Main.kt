package com.example.weatherapp.model


import com.google.gson.annotations.SerializedName

import androidx.annotation.Keep
@Keep
data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("temp_min")
    val tempMin: Double
)