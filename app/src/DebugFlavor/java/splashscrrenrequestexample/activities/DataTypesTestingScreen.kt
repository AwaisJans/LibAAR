package splashscrrenrequestexample.activities

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.ImageViewCompat
import com.example.splashscrrenrequestexample.R
import splashscrrenrequestexample.MyConfig

class DataTypesTestingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_types_testing_screen)

        setStatusBarDrawable()



        val tvStr = findViewById<TextView>(R.id.strTV)
        val tvInt = findViewById<TextView>(R.id.intTV)
        val tvBool = findViewById<TextView>(R.id.booleanTV)
        val ivImg = findViewById<ImageView>(R.id.imgIV)


        val config = MyConfig()


        tvStr.text = config.name
        tvInt.text = config.age.toString()
        tvBool.text = config.isOld.toString()

        ivImg.layoutParams.width = config.imageWidth
        ivImg.layoutParams.height = config.imageHeight


        ivImg.setColorFilter(Color.parseColor(config.tintColor))

        tvStr.textSize = config.fontSize.toFloat()
        tvInt.textSize = config.fontSize.toFloat()
        tvBool.textSize = config.fontSize.toFloat()

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