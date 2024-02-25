package com.example.splashscrrenrequestexample.activities

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.splashscrrenrequestexample.MyConfig
import com.example.splashscrrenrequestexample.R
import com.example.splashscrrenrequestexample.model.DashboardItem
import com.example.splashscrrenrequestexample.model.DashboardResponse
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class TestingRVScreen : AppCompatActivity() {

    private lateinit var postAdapter: TestingRVAdapter
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_rvscreen)
        setStatusBarDrawable()

        recyclerView = findViewById(R.id.recyclerView)

        val config = MyConfig()


        var jsonString = ""


        val tb = findViewById<Toolbar>(R.id.tb1)


            jsonString = readJsonFile(R.raw.original_file)
            tb.title = "Original List"


        val dashboardResponse = Gson().fromJson(jsonString, DashboardResponse::class.java)
        val dashboardItems: List<DashboardItem> = dashboardResponse.dashboard



        postAdapter = TestingRVAdapter(dashboardItems)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        recyclerView.adapter = postAdapter



    }


    fun Context.readJsonFile(resourceId: Int): String {
        val inputStream: InputStream = resources.openRawResource(resourceId)
        val reader = BufferedReader(InputStreamReader(inputStream))
        return buildString {
            try {
                var line = reader.readLine()
                while (line != null) {
                    append(line).append('\n')
                    line = reader.readLine()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                try {
                    reader.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
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


    class TestingRVAdapter(private val products: List<DashboardItem>) :
        RecyclerView.Adapter<TestingRVAdapter.PostViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false)
            return PostViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            val post = products[position]
            holder.titleTextView.text = post.title

        }

        override fun getItemCount(): Int = products!!.size

        class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)


        }
    }




}