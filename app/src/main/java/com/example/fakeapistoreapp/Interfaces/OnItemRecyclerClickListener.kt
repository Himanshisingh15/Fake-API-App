package com.example.fakeapistoreapp.Interfaces

import com.example.fakeapistoreapp.Response.ProductList

interface onItemRecyclerClickListener {

    fun onItemClick(position: Int,productList: ProductList)

}