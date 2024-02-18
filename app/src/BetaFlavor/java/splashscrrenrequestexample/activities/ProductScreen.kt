package splashscrrenrequestexample.activities

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
import splashscrrenrequestexample.ApiUtil.Products
import com.example.splashscrrenrequestexample.R

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


    class PostAdapter(private val products: ArrayList<Products>?) :
        RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
            return PostViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            val post = products?.get(position)
            holder.titleTextView.text = post?.title
            holder.categoryTV.text = "Category: ${post?.category}"
            holder.priceTV.text =  "Price: ${post?.price.toString()} $"


            // Using Glide to load the image
            Glide.with(holder.itemView.context)
                .load(post?.image)
                .placeholder(R.drawable.splash) // Placeholder image while loading
                .error(R.drawable.splash) // Image to display if loading fails
                .into(holder.imageProduct)


        }

        override fun getItemCount(): Int = products!!.size

        class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
            var categoryTV: TextView = itemView.findViewById(R.id.category)
            var priceTV: TextView = itemView.findViewById(R.id.price)
            var imageProduct: ImageView = itemView.findViewById(R.id.img1)

        }
    }

}