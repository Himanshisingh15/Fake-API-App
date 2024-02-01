package com.example.fakeapistoreapp.UserModels

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("firstname")
    var firstname: String,

    @SerializedName("lastname")
    var lastname: String

    )
