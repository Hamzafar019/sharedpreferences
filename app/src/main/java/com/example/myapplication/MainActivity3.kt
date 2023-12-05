package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding:ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor=getPreferences(MODE_PRIVATE)
        binding.checkBox.isChecked=editor.getBoolean("check",true)
        binding.name.setText(editor.getString("name",null))
        binding.button.setOnClickListener{
            val editor=getPreferences(MODE_PRIVATE).edit()
            editor.putString("name",binding.name.text.toString())
            editor.putBoolean("check",binding.checkBox.isChecked)
            editor.apply()
        }
    }
}