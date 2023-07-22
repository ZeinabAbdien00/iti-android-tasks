package com.iti.android_2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iti.android_2.R
import com.iti.android_2.adapter.TrendRestaurantsRVAdapter
import com.iti.android_2.databinding.ActivityMain2Binding
import com.iti.android_2.model.TrendRestaurant

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var restaurantAdapter: TrendRestaurantsRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRestaurantRecyclerView()
        setOnClicks()

    }

    private fun setOnClicks() {
        binding.tvBackArrow.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpRestaurantRecyclerView() {
        binding.rvRestaurant2.apply {

            val dummy = setUpRestaurantArrayList()
            restaurantAdapter =
                TrendRestaurantsRVAdapter(restaurantArrayList = dummy, context = this@MainActivity2)

            val messageLayoutManager =
                LinearLayoutManager(this@MainActivity2, GridLayoutManager.VERTICAL, false)

            layoutManager = messageLayoutManager
            adapter = restaurantAdapter
        }
    }

    private fun setUpRestaurantArrayList(): ArrayList<TrendRestaurant> {
        val dummyRestaurantData = ArrayList<TrendRestaurant>()
        dummyRestaurantData.add(
            TrendRestaurant(
                resImg = R.drawable.img1,
                state = getString(R.string.open),
                rate = "5.0",
                name = getString(R.string.happy_bones),
                type = getString(R.string.italian),
                distance = "12 km",
                address = getString(R.string.address)
            )
        )

        dummyRestaurantData.add(
            TrendRestaurant(
                resImg = R.drawable.img_2,
                state = getString(R.string.close),
                rate = "5.0",
                name = getString(R.string.uncle_boons),
                type = getString(R.string.maxican),
                distance = "12 km",
                address = getString(R.string.address)
            )
        )

        dummyRestaurantData.add(
            TrendRestaurant(
                resImg = R.drawable.img_3,
                state = getString(R.string.open),
                rate = "5.0",
                name = getString(R.string.happy_bones),
                type = getString(R.string.chinese),
                distance = "12 km",
                address = getString(R.string.address)
            )
        )

        dummyRestaurantData.add(
            TrendRestaurant(
                resImg = R.drawable.img1,
                state = getString(R.string.close),
                rate = "5.0",
                name = getString(R.string.uncle_boons),
                type = getString(R.string.italian),
                distance = "12 km",
                address = getString(R.string.address)
            )
        )

        dummyRestaurantData.add(
            TrendRestaurant(
                resImg = R.drawable.img_2,
                state = getString(R.string.close),
                rate = "5.0",
                name = getString(R.string.uncle_boons),
                type = getString(R.string.maxican),
                distance = "12 km",
                address = getString(R.string.address)
            )
        )

        dummyRestaurantData.add(
            TrendRestaurant(
                resImg = R.drawable.img_3,
                state = getString(R.string.open),
                rate = "5.0",
                name = getString(R.string.happy_bones),
                type = getString(R.string.chinese),
                distance = "12 km",
                address = getString(R.string.address)
            )
        )

        return dummyRestaurantData
    }
}