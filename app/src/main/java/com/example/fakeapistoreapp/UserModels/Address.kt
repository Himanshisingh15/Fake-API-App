package com.example.fakeapistoreapp.UserModels

import com.google.gson.annotations.SerializedName

data class Address(

    @SerializedName("geolocation")
    var geolocation: Geolocation,

    @SerializedName("city")
    var city: String,

    @SerializedName("street")
    var street: String,

    @SerializedName("number")
    var homeno: Int,

    @SerializedName("zipcode")
    var zipcode: String

)
