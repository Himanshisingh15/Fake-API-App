package com.example.fakeapistoreapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapistoreapp.Interfaces.userRecyclerViewItemClickListener
import com.example.fakeapistoreapp.Response.UserList
import com.example.fakeapistoreapp.databinding.CustomUserListBinding

class UserRecyclerViewAdapter(private var context: Context, var list: UserList, var userRecyclerViewItemClickListener: userRecyclerViewItemClickListener) : RecyclerView.Adapter<UserRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(var bindingCustom : CustomUserListBinding?) : RecyclerView.ViewHolder(bindingCustom!!.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var bindingCustom = CustomUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bindingCustom)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var userDetails = list[position]

        holder.bindingCustom!!.tvUsername.text = "Name   - ${userDetails.name.firstname} ${userDetails.name.lastname}"
        holder.bindingCustom!!.tvEmail.text = "Phone  - ${userDetails.phone}"

        holder.itemView.setOnClickListener{
            userRecyclerViewItemClickListener.onUserItemClick(position, list)
        }
    }


}