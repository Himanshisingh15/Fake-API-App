package com.example.fakeapistoreapp.ProductModels

import com.example.fakeapistoreapp.Response.ProductList
import com.example.fakeapistoreapp.Response.UserList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface ApiMethods {

    @GET("/products")
    fun getProducts(): retrofit2.Call<ProductList>

    @GET("/users")
    fun getUsers(): Call<UserList>
}