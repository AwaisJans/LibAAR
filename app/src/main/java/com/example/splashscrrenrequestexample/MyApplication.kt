package com.example.splashscrrenrequestexample

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.splashscrrenrequestexample.timber.src.main.java.timber.log.Timber


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }


    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context?=null
    }
}
