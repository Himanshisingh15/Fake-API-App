package com.example.fakeapistoreapp.UserModels

import com.google.gson.annotations.SerializedName

data class UserData(

    @SerializedName("address")
    var address: Address,

    @SerializedName("id")
    var id: Int,

    @SerializedName("email")
    var email: String,

    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String,

    @SerializedName("name")
    var name: Name,

    @SerializedName("phone")
    var phone: String

)
