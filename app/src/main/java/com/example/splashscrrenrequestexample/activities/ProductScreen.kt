package com.example.splashscrrenrequestexample.activities

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.splashscrrenrequestexample.ApiUtil.Products
import com.example.splashscrrenrequestexample.R
import com.example.splashscrrenrequestexample.adapter.PostAdapter

class ProductScreen : AppCompatActivity() {


    private lateinit var postAdapter: PostAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        setStatusBarDrawable()

        val receivedPostsList = intent.getParcelableArrayListExtra<Products>("productsList")

        recyclerView = findViewById(R.id.recyclerView)

        postAdapter = PostAdapter(receivedPostsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setStatusBarDrawable() {
        val window: Window = window
        val background: Drawable = resources.getDrawable(R.drawable.gradient)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(android.R.color.transparent)
        window.navigationBarColor = resources.getColor(android.R.color.transparent)
        window.setBackgroundDrawable(background)
    }




}