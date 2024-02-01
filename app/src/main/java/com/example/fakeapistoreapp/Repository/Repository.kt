package com.example.fakeapistoreapp.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.fakeapistoreapp.Response.ProductList
import com.example.fakeapistoreapp.Response.UserList
import com.example.fakeapistoreapp.Retrofit.RetrofitProducts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    var productLiveData: MutableLiveData<ProductList> = MutableLiveData()
    var isLoading : MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value = true
    }
    
    var userLiveData : MutableLiveData<UserList> = MutableLiveData()

    fun getProducts(): MutableLiveData<ProductList> {

        var call = RetrofitProducts.apiCall.getProducts()
        call.enqueue(object : Callback<ProductList> {
            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                if (response.isSuccessful) {
                    isLoading.value = false

                    productLiveData.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                isLoading.value = false
                Log.d("Failure", "onFailure: ${t.message}")
            }
        })

        return productLiveData
    }

    fun getUsers(): MutableLiveData<UserList> {

        var call = RetrofitProducts.apiCall.getUsers()

        call.enqueue(object : Callback<UserList>{
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if (response.isSuccessful){

                    userLiveData.value = response.body()
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                isLoading.value = false
            }

        })
        return userLiveData
        
    }

}

