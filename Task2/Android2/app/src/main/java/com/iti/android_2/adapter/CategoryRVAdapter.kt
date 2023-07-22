package com.iti.android_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.iti.android_2.R
import com.iti.android_2.databinding.CategoryItemBinding
import com.iti.android_2.model.Category
import com.squareup.picasso.Picasso

class CategoryRVAdapter(private var categoryArrayList: ArrayList<Category>?, val context: Context) :
    RecyclerView.Adapter<CategoryRVAdapter.CategoryAdapter>() {

    inner class CategoryAdapter(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val categoryImg = binding.ivCategory
        val categoryType = binding.tvCategory
        val gradient = binding.vCategoryGradient

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter {
        val binding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryAdapter(binding)
    }

    override fun getItemCount(): Int {
        return categoryArrayList!!.size
    }

    override fun onBindViewHolder(holder: CategoryAdapter, position: Int) {
        val itemData = categoryArrayList!![position]

        Picasso.get().load(itemData.image)
            .resize(150, 150)
            .centerCrop()
            .into(holder.categoryImg)

        holder.categoryType.text = itemData.type
        when (itemData.type) {
            "Italian" -> {
                holder.gradient.setBackgroundResource(R.drawable.italic_gradient_shape)
            }
            "Maxican" -> {
                holder.gradient.setBackgroundResource(R.drawable.maxican_gradient_shape)
            }
            else -> {
                holder.gradient.setBackgroundResource(R.drawable.chinese_gradient_shape)
            }
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Item is clicked", Toast.LENGTH_SHORT).show()
        }
    }

}