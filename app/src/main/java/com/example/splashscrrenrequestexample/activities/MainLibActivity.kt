package com.example.splashscrrenrequestexample.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.splashscrrenrequestexample.ApiUtil.Products
import com.example.splashscrrenrequestexample.MyConfig
import com.example.splashscrrenrequestexample.R

class MainLibActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lib)
        setStatusBarDrawable()


        MyConfig.callIfDebug {
            Log.d("TagDebug123","its a debug")
        }



        val btnProducts: Button = findViewById(R.id.btnProducts)
        val btnCheckingTypes: Button = findViewById(R.id.btnCheckingTypes)
        val btnRVScreenTest: Button = findViewById(R.id.btnCheckRVScreen)
        val btnCheckDebugOrRelease: Button = findViewById(R.id.checkDebugOrRelease)
        val tvTesting: TextView = findViewById(R.id.idConfigTesting)

        val config = MyConfig()
        tvTesting.text = config.internalVariable()

        btnCheckingTypes.setOnClickListener {
            val intent = Intent(this@MainLibActivity, DataTypesTestingScreen::class.java)
            startActivity(intent)
        }

        btnRVScreenTest.setOnClickListener {
            val intent = Intent(this@MainLibActivity, TestingRVScreen::class.java)
            startActivity(intent)
        }


        btnCheckDebugOrRelease.setOnClickListener {
            val intent = Intent(this@MainLibActivity, BuildVariantScreen::class.java)
            startActivity(intent)
        }



        btnProducts.setOnClickListener {
            val intent = Intent(this@MainLibActivity, ProductScreen::class.java)
            intent.putParcelableArrayListExtra("productsList", productList())
            startActivity(intent)
        }

    }

    private fun productList(): ArrayList<Products>? {
        return intent.getParcelableArrayListExtra<Products>("productsList")
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