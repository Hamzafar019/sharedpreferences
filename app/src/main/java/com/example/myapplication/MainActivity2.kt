package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding
import com.google.gson.Gson

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor=getSharedPreferences("My_Settings", MODE_PRIVATE)
//        val user= Gson().fromJson(editor.getString("user_data",null),User::class.java)
//        binding.textView.setText("Your email is ${user.email} and password is ${user.password}")
        binding.textView.setText("Your email is ${editor.getString("email",null)} and password is ${editor.getString("password",null)}")

    }
}