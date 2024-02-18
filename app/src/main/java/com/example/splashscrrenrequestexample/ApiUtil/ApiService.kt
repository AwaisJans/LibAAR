package com.example.splashscrrenrequestexample.ApiUtil

import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.splashscrrenrequestexample.MyApplication
import org.json.JSONArray
import java.util.Locale

object ApiService {

    private const val BASE_URL = "https://fakestoreapi.com"




    fun getProducts(callback: (List<Products>?) -> Unit) {
        val url = "$BASE_URL/products/"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                val posts = parseJsonArray(response)
                callback(posts)
            },
            { _ ->
                callback(null)
            }
        )

        Volley.newRequestQueue(MyApplication.context).add(jsonArrayRequest)
    }

    private fun parseJsonArray(jsonArray: JSONArray): List<Products> {
        val products = mutableListOf<Products>()
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val product = Products(
                id = jsonObject.getInt(Members.ID.toString().toLowerCase(Locale.ROOT)),
                title = jsonObject.getString(Members.TITLE.toString().toLowerCase(Locale.ROOT)),
                price = jsonObject.getDouble(Members.PRICE.toString().toLowerCase(Locale.ROOT)),
                category = jsonObject.getString(Members.CATEGORY.toString().toLowerCase(Locale.ROOT)),
                image = jsonObject.getString(Members.IMAGE.toString().toLowerCase(Locale.ROOT))
            )
            products.add(product)
        }
        return products
    }

}
