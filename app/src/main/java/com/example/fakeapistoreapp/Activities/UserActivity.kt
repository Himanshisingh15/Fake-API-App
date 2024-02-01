package com.example.fakeapistoreapp.Activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakeapistoreapp.R
import com.example.fakeapistoreapp.databinding.ActivityUserBinding
import com.example.fakeapistoreapp.ViewModels.ApiViewModel
import com.example.fakeapistoreapp.Adapter.UserRecyclerViewAdapter
import com.example.fakeapistoreapp.Interfaces.userRecyclerViewItemClickListener
import com.example.fakeapistoreapp.Response.UserList

class UserActivity: AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var viewModel: ApiViewModel
    private lateinit var userAdapter: UserRecyclerViewAdapter
    lateinit var progressBar: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)

        viewModel = ViewModelProvider(this)[ApiViewModel::class.java]

        progressBar = ProgressDialog(this)
        progressBar.setMessage("Loading, Please wait...")
        progressBar.setCancelable(false)
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        viewModel.isLoading.observe(this, Observer {
            if (it) {
                progressBar.show()
            } else {
                progressBar.dismiss()
            }
        })

        binding.rvUserData.layoutManager = LinearLayoutManager(this)

        viewModel.getUsers().observe(this, Observer {
            userAdapter = UserRecyclerViewAdapter(this, it, object : userRecyclerViewItemClickListener {
                    override fun onUserItemClick(position: Int, userList: UserList) {
                        var user = userList[position]
                        userDetails(
                            user.username,
                            user.name.firstname,
                            user.name.lastname,
                            user.email,
                            user.phone,
                            user.password,
                            user.address.homeno,
                            user.address.street,
                            user.address.geolocation.lat,
                            user.address.geolocation.long,
                            user.address.city,
                            user.address.zipcode)

                    }
                })
            binding.rvUserData.adapter = userAdapter
        })

    }

    fun userDetails(username: String, fname: String, lname: String, email: String, mobile: String, password: String,
                   homeNo: Int, street: String, lat: String, long: String, city: String, zipcode: String){

        var intentUserDetails = Intent(this@UserActivity, UserDetailsActivity::class.java)

        intentUserDetails.putExtra("username", username)
        intentUserDetails.putExtra("fname", fname)
        intentUserDetails.putExtra("lname", lname)
        intentUserDetails.putExtra("email", email)
        intentUserDetails.putExtra("phone", mobile)
        intentUserDetails.putExtra("password", password)
        intentUserDetails.putExtra("homeno", homeNo)
        intentUserDetails.putExtra("street", street)
        intentUserDetails.putExtra("lat", lat)
        intentUserDetails.putExtra("long", long)
        intentUserDetails.putExtra("city", city)
        intentUserDetails.putExtra("zipcode", zipcode)

        startActivity(intentUserDetails)

    }

}














