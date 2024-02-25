package com.example.splashscrrenrequestexample

class MyConfig {
    companion object{
//        private const val RELEASE = "release"
//        private const val BETA = "beta"
//        private const val DEBUG = "debug"
//        fun callIfDebug(myCallingVoid:()->Unit){
//            if(BuildConfig.BUILD_TYPE == DEBUG){
//                myCallingVoid()
//            }
//        }
//
//        fun callIfRelease(myCallingVoid:()->Unit){
//            if(BuildConfig.BUILD_TYPE == RELEASE){
//                myCallingVoid()
//            }
//        }
//
//        fun callIfBeta(myCallingVoid:()->Unit){
//            if(BuildConfig.BUILD_TYPE == BETA){
//                myCallingVoid()
//            }
//        }
    }
    fun internalVariable(): String {
        return "Library"
    }
    // String
    var name = "MasterMind"
    // Int
    var age = 23
    // Boolean
    var isOld = true
    // List
    var list = listOf("Salman Khan",
        "Amir Khan",
        "Shahrukh Khan",
        "Fawad Khan",
        "Ahsan Khan",
        "Mahira Khan",
        "Saima Bano")
    // Tint Color
    var tintColor = "#1a1a1a"
    // Font Size
    var fontSize = 30
    // Image Height
    var imageHeight = 50
    // Image Width
    var imageWidth = 50
}