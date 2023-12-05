package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var listener:SharedPreferences.OnSharedPreferenceChangeListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val manager=PreferenceManager.getDefaultSharedPreferences(this)
        listener=SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if(key.equals("change_UI")){

                if(manager.getBoolean("change_UI",false)==false){
                    binding.mainlayout.setBackgroundColor(Color.CYAN)
                }
                else{
                    binding.mainlayout.setBackgroundColor(Color.BLUE)
                }
            }
        }

        manager.registerOnSharedPreferenceChangeListener(listener)


        binding.settings.setOnClickListener{
            startActivity(Intent(this,MainActivity3::class.java))
        }
        binding.settings2.setOnClickListener{
            startActivity(Intent(this,SettingsActivity::class.java))
        }

        binding.clear.setOnClickListener{

            val editor=getSharedPreferences("My_Settings", MODE_PRIVATE).edit()
            editor.clear()
            editor.apply()
        }


        val editor=getSharedPreferences("My_Settings", MODE_PRIVATE)
//        val user=Gson().fromJson(editor.getString("user_data",null),User::class.java)
//
//        binding.email.setText(user.email)
//        binding.password.setText(user.password)
        binding.email.setText(editor.getString("email",null))
        binding.password.setText(editor.getString("password",null))

        binding.login.setOnClickListener{
            val editor=getSharedPreferences("My_Settings", MODE_PRIVATE).edit()
            var user=User(binding.email.text.toString(),binding.password.text.toString())
            editor.putString("email",binding.email.text.toString())
            editor.putString("password",binding.password.text.toString())
//            var gson= Gson()
//            var data=gson.toJson(user,User::class.java)
//            editor.putString("user_data",data)

            editor.apply()
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }
}