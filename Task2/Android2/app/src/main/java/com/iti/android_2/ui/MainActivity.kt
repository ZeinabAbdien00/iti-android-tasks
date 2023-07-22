package com.iti.android_2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iti.android_2.R
import com.iti.android_2.adapter.CategoryRVAdapter
import com.iti.android_2.adapter.FriendsRVAdapter
import com.iti.android_2.adapter.TrendRestaurantsRVAdapter
import com.iti.android_2.databinding.ActivityMainBinding
import com.iti.android_2.model.Category
import com.iti.android_2.model.TrendRestaurant

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var restaurantAdapter: TrendRestaurantsRVAdapter
    private lateinit var categoryAdapter: CategoryRVAdapter
    private lateinit var friendsRVAdapter: FriendsRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRestaurantRecyclerView()
        setUpCategoryRecyclerView()
        setFriendRecyclerView()
        setOnClicks()
    }

    private fun setFriendRecyclerView() {

        binding.rvFriends.apply {

            val dummy = setUpFriendsArrayList()
            friendsRVAdapter =
                FriendsRVAdapter(dummy, context = this@MainActivity)

            val messageLayoutManager =
                LinearLayoutManager(this@MainActivity, GridLayoutManager.HORIZONTAL, false)

            layoutManager = messageLayoutManager
            adapter = friendsRVAdapter
        }

    }

    private fun setUpFriendsArrayList(): ArrayList<String> {
        val dummyFriendData = ArrayList<String>()
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231019.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231020.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231019.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231020.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231019.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231020.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231019.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231020.png")
        return dummyFriendData
    }

    private fun setOnClicks() {
        binding.tvSeeAll.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun setUpCategoryRecyclerView() {
        binding.rvCategory.apply {

            val dummy = setUpCategoryArrayList()
            categoryAdapter =
                CategoryRVAdapter(dummy, context = this@MainActivity)

            val messageLayoutManager =
                LinearLayoutManager(this@MainActivity, GridLayoutManager.HORIZONTAL, false)

            layoutManager = messageLayoutManager
            adapter = categoryAdapter
        }
    }

    private fun setUpCategoryArrayList(): ArrayList<Category> {
        val dummyCategoryData = ArrayList<Category>()
        dummyCategoryData.add(
            Category(
                type = getString(R.string.italian),
                image = R.drawable.img1
            )
        )
        dummyCategoryData.add(
            Category(
                type = getString(R.string.chinese),
                image = R.drawable.img_2
            )
        )
        dummyCategoryData.add(
            Category(
                type = getString(R.string.maxican),
                image = R.drawable.img_3
            )
        )
        return dummyCategoryData
    }

    private fun setUpRestaurantRecyclerView() {
        binding.rvRestaurant.apply {

            val dummy = setUpRestaurantArrayList()
            restaurantAdapter =
                TrendRestaurantsRVAdapter(restaurantArrayList = dummy, context = this@MainActivity)

            val messageLayoutManager =
                LinearLayoutManager(this@MainActivity, GridLayoutManager.HORIZONTAL, false)

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
