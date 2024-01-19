package com.example.splashscrrenrequestexample.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscrrenrequestexample.ApiUtil.ApiService
import com.example.splashscrrenrequestexample.R


@SuppressLint("CustomSplashScreen")
class SplashLibScreen : AppCompatActivity() {


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        setStatusBarDrawable()


        fetchData()
    }

    private fun fetchData() {

        ApiService.getProducts { posts ->

            if (posts != null) {
                val convertedList: ArrayList<out Parcelable> = ArrayList(posts)

                Handler().postDelayed({
                    val intent = Intent(this@SplashLibScreen, MainLibActivity::class.java)
                    intent.putParcelableArrayListExtra("productsList", convertedList)
                    startActivity(intent)
                    finish()
                }, 1000)
        } else {
            Toast.makeText(this@SplashLibScreen, "Can not get Data", Toast.LENGTH_SHORT).show()
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











}