package com.example.fakeapistoreapp.ProductModels

import com.google.gson.annotations.SerializedName

data class Rating(

    @SerializedName("rate")
    var rate: Double,

    @SerializedName("count")
    var count: Long
)
