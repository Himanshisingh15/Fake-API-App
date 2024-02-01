package com.example.fakeapistoreapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.fakeapistoreapp.R
import com.example.fakeapistoreapp.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {
    lateinit var userBinding : ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_details)

        var data = intent
        var username = data.getStringExtra("username")
        var fname = data.getStringExtra("fname")
        var lname = data.getStringExtra("lname")
        var email = data.getStringExtra("email")
        var mobile = data.getStringExtra("phone")
        var password = data.getStringExtra("password")
        var homeNo = data.getIntExtra("homeno",0)
        var street = data.getStringExtra("street")
        var latitude = data.getStringExtra("lat")
        var longitude = data.getStringExtra("long")
        var city = data.getStringExtra("city")
        var zipcode = data.getStringExtra("zipcode")


        userBinding.tvUsername.text = "Username :  $username"
        userBinding.tvName.text = "Name :  $fname $lname"
        userBinding.tvEmail.text = "Email :  $email"
        userBinding.tvAddress.text = "Address : $homeNo, $street, $city"
        userBinding.tvGeolocation.text = "Geo : \n         lat :  $latitude \n                  long : $longitude"
        userBinding.tvZipcode.text = "Zip Code :  $zipcode"
        userBinding.tvMobile.text = "Phone :  $mobile"
        userBinding.tvPassword.text = "Password :  $password"

    }
}