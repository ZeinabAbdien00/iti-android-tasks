package com.example.android_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener {
            rollTwoDices()
        }
    }

    private fun rollTwoDices() {
        val drawableResource = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        binding.diceImage.setImageResource(drawableResource)

        val drawableResource1 = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        binding.diceImage1.setImageResource(drawableResource1)
    }
}

