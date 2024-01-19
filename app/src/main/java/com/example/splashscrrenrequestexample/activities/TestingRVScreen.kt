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
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscrrenrequestexample.MyConfig
import com.example.splashscrrenrequestexample.R

class TestingRVScreen : AppCompatActivity() {

    private lateinit var postAdapter: TestingRVAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_rvscreen)
        setStatusBarDrawable()

        recyclerView = findViewById(R.id.recyclerView)

        val config = MyConfig()
        postAdapter = TestingRVAdapter(config.list)
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


    class TestingRVAdapter(private val products: List<String>) :
        RecyclerView.Adapter<TestingRVAdapter.PostViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false)
            return PostViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            val post = products[position]
            holder.titleTextView.text = post

        }

        override fun getItemCount(): Int = products!!.size

        class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)


        }
    }




}