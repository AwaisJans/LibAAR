package com.example.splashscrrenrequestexample.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.splashscrrenrequestexample.ApiUtil.Products
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.splashscrrenrequestexample.R

class PostAdapter(private val products: ArrayList<Products>?) :
        RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
            return PostViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder as PostViewHolder
            val post = products?.get(position)
            holder.titleTextView.text = post?.title
            holder.categoryTV.text = "Category: ${post?.category}"
            holder.priceTV.text =  "Price: ${post?.price.toString()} $"
            
            // Using Glide to load the image
            Glide.with(holder.itemView.context)
                .load(post?.image)
                .placeholder(R.drawable.splash) // Placeholder image while loading
                .error(R.drawable.splash) // Image to display if loading fails
                .into(holder.imageProduct)
            
        }

        override fun getItemCount(): Int = products!!.size

        class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
            var categoryTV: TextView = itemView.findViewById(R.id.category)
            var priceTV: TextView = itemView.findViewById(R.id.price)
            var imageProduct: ImageView = itemView.findViewById(R.id.img1)

        }
    }