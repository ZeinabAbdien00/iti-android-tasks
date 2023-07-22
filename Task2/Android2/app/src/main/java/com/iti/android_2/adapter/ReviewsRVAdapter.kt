package com.iti.android_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.iti.android_2.databinding.FriendItemBinding
import com.squareup.picasso.Picasso

class ReviewsRVAdapter(private var reviewsArrayList: ArrayList<String>?, val context: Context) :
    RecyclerView.Adapter<ReviewsRVAdapter.ReviewsAdapter>() {

    inner class ReviewsAdapter(private val binding: FriendItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val friendImage = binding.ivFriend

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsAdapter {
        val binding = FriendItemBinding.inflate(LayoutInflater.from(parent.context) , parent, false)
        return ReviewsAdapter(binding)
    }

    override fun getItemCount(): Int {
        return reviewsArrayList!!.size
    }

    override fun onBindViewHolder(holder: ReviewsAdapter, position: Int) {
        val itemData = reviewsArrayList!![position]

        holder.friendImage.layoutParams.width = 75
        holder.friendImage.layoutParams.height = 75

        val marginLayoutParams = MarginLayoutParams(holder.friendImage.layoutParams)
        marginLayoutParams.setMargins(-8, 0, -30, 0)
        holder.friendImage.layoutParams = marginLayoutParams

        Picasso.get().load(itemData)
            .resize(65, 68)
            .centerCrop()
            .into(holder.friendImage)

    }

}