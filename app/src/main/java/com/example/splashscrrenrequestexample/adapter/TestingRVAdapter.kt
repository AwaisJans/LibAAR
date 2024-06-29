package com.example.splashscrrenrequestexample.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscrrenrequestexample.R
import com.example.splashscrrenrequestexample.model.DashboardItem

class TestingRVAdapter(private val products: List<DashboardItem>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false)
            return PostViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder as PostViewHolder
            val post = products[position]
            holder.titleTextView.text = post.title

        }

        override fun getItemCount(): Int = products.size

        class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)


        }
    }