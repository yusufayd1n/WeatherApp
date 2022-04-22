package com.example.weatherapp.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Wind(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("speed")
    val speed: Double
)