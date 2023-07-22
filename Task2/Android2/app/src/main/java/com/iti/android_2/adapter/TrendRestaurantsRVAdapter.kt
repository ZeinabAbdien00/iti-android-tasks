package com.iti.android_2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.iti.android_2.R
import com.iti.android_2.databinding.TrendRestaurantItemBinding
import com.iti.android_2.model.TrendRestaurant
import com.squareup.picasso.Picasso


class TrendRestaurantsRVAdapter(
    private var restaurantArrayList: ArrayList<TrendRestaurant>?,
    val context: Context
) :
    RecyclerView.Adapter<TrendRestaurantsRVAdapter.TrendRestaurantsAdapter>() {

    private lateinit var reviewsAdapter : ReviewsRVAdapter

    inner class TrendRestaurantsAdapter(private val binding: TrendRestaurantItemBinding) :

        ViewHolder(binding.root) {
        val resImg = binding.ivRestaurantImage
        val state = binding.btnState
        val rate = binding.flRate
        val nameRestaurant = binding.tvName
        val type = binding.tvType
        val distance = binding.tvDistance
        val address = binding.tvAddress
        val reviewsRv = binding.rvReviews


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendRestaurantsAdapter {

        val binding =
            TrendRestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendRestaurantsAdapter(binding)
    }

    override fun getItemCount(): Int {
        return restaurantArrayList!!.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: TrendRestaurantsAdapter, position: Int) {

        val itemData = restaurantArrayList!![position]

        holder.address.text = itemData.address
        holder.nameRestaurant.text = itemData.name
        holder.distance.text = itemData.distance

        holder.type.text = itemData.type
        when (itemData.type) {
            "Italian" -> holder.type.setBackgroundResource(R.drawable.italic_gradient_shape)
            "Maxican" -> holder.type.setBackgroundResource(R.drawable.maxican_gradient_shape)
            else -> holder.type.setBackgroundResource(R.drawable.chinese_gradient_shape)
        }

        holder.state.text = itemData.state
        if (itemData.state == "Open") holder.state.setTextColor(R.color.green)

        Picasso.get().load(itemData.resImg)
            .resize(350, 180)
            .centerCrop()
            .into(holder.resImg)

        setReviewsRecyclerView(holder.reviewsRv)


        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Item is clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setReviewsRecyclerView(rv: RecyclerView) {
        rv.apply {

            val dummy = setUpReviewsArrayList()
            reviewsAdapter =
                ReviewsRVAdapter(dummy, context = context)

            val messageLayoutManager =
                LinearLayoutManager(context, GridLayoutManager.HORIZONTAL, true )

            layoutManager = messageLayoutManager
            adapter = reviewsAdapter

        }
    }

    private fun setUpReviewsArrayList(): ArrayList<String>? {
        val dummyFriendData = ArrayList<String>()
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231019.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231020.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231019.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231020.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231019.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231020.png")
        dummyFriendData.add("https://cdn-icons-png.flaticon.com/512/5231/5231019.png")

        return dummyFriendData
    }
}

//class OverlapDecoration : ItemDecoration() {
//    fun getItemOffsets(
//        outRect: Rect,
//        view: View?,
//        parent: RecyclerView?,
//        state: RecyclerView.State?
//    ) {
//        outRect.set(0, 0, vertOverlap, 0)
//    }
//
//    companion object {
//        private const val vertOverlap = -20
//    }
//}