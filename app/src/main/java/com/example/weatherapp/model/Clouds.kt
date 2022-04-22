package com.example.weatherapp.model


import com.google.gson.annotations.SerializedName

import androidx.annotation.Keep

@Keep
data class Clouds(
    @SerializedName("all")
    val all: Int
)