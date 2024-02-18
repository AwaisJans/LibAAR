package com.example.splashscrrenrequestexample.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscrrenrequestexample.MyConfig
import com.example.splashscrrenrequestexample.R

class BuildVariantScreen: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyConfig.callIfDebug {
            setContentView(R.layout.debug_layout)
        }

        MyConfig.callIfRelease {
            setContentView(R.layout.release_layout)
        }


    }


}


