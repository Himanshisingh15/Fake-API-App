package com.example.fakeapistoreapp.Interfaces

import com.example.fakeapistoreapp.Response.UserList

interface userRecyclerViewItemClickListener {

    fun onUserItemClick(position: Int, userList: UserList)
}