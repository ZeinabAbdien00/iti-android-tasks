package com.iti.android_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.iti.android_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClicks()
    }

    private fun setOnClicks() {
        binding.rbNextDay.setOnCheckedChangeListener { buttonView, isChecked ->
            check(binding.rbNextDay)
        }
        binding.rbSameDay.setOnCheckedChangeListener { buttonView, isChecked ->
            check(binding.rbSameDay)
        }
        binding.rbPickUp.setOnCheckedChangeListener { buttonView, isChecked ->
            check(binding.rbPickUp)
        }
    }
    private fun check(radioButton: RadioButton){
        binding.apply {
            if (etAddress.text.isNotEmpty() && etName.text.isNotEmpty() && etNote.text.isNotEmpty() && etPhone.text.isNotEmpty()) {
                Toast.makeText(this@MainActivity , radioButton.text.toString() , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity , "Please, Complete all Data" , Toast.LENGTH_SHORT).show()
                radioButton.isChecked = false
            }
        }
    }
}