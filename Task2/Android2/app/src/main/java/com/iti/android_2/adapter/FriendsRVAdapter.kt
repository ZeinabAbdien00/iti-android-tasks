package com.iti.android_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.iti.android_2.databinding.FriendItemBinding
import com.iti.android_2.model.Category
import com.squareup.picasso.Picasso

class FriendsRVAdapter(private var friendArrayList: ArrayList<String>?, val context: Context) :
    RecyclerView.Adapter<FriendsRVAdapter.FriendsAdapter>() {

    inner class FriendsAdapter(private val binding: FriendItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val friendImage = binding.ivFriend

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsAdapter {
        val binding = FriendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendsAdapter(binding)
    }

    override fun getItemCount(): Int {
        return friendArrayList!!.size
    }

    override fun onBindViewHolder(holder: FriendsAdapter, position: Int) {
        val itemData = friendArrayList!![position]

        Picasso.get().load(itemData)
            .resize(68, 68)
            .centerCrop()
            .into(holder.friendImage)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Person", Toast.LENGTH_SHORT).show()
        }

    }
}

//fun getItemOffsets(outRect: Rect, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
//    outRect.set(0, 0, vertOverlap, 0)
//}