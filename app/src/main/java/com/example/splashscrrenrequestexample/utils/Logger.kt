package com.example.splashscrrenrequestexample.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.util.Log
import android.widget.Toast

class Logger {
    companion object {
        fun logDebugMessage(context: Context, tag: String, message: String) {
            var isDebuggable: Boolean
            try {
                val appInfo = context.applicationInfo
                // 1 = debuggable application, 0 = other flavor of the app
                isDebuggable = (appInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
            } catch (e: Exception) {
                isDebuggable = false
            }

            if (isDebuggable) {
                Log.d(tag, message)
//                Toast.makeText(context, "Log.d($tag, $message)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}