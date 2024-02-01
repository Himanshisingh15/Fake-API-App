package com.example.fakeapistoreapp.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakeapistoreapp.Response.ProductList
import com.example.fakeapistoreapp.Repository.Repository
import com.example.fakeapistoreapp.Response.UserList

class ApiViewModel: ViewModel() {
    var apiRepository = Repository()
    var liveData: MutableLiveData<ProductList>? = null
    var isLoading: MutableLiveData<Boolean> = apiRepository.isLoading

    fun getProducts(): MutableLiveData<ProductList>{
        liveData = apiRepository.getProducts()
       return liveData!!

    }

    fun getUsers(): MutableLiveData<UserList>{

        return apiRepository.getUsers()
    }
}