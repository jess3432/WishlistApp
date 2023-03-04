package com.example.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishlist_rv = findViewById<RecyclerView>(R.id.wishlist_rv)

        // Create adapter passing in the list of wishlist items
        var wishlists: MutableList<Wishlist> = ArrayList()
        val adapter = WishlistAdapter(wishlists)

        // Attach the adapter to the RecyclerView to populate items
        wishlist_rv.adapter = adapter
        // Set layout manager to position the items
        wishlist_rv.layoutManager = LinearLayoutManager(this)

        val itemTv = findViewById<EditText>(R.id.itemTv)
        val priceTv = findViewById<EditText>(R.id.priceTv)
        val urlTv = findViewById<EditText>(R.id.urlTv)

        findViewById<Button>(R.id.button).setOnClickListener {
            // Add wishlist when user clicks on submit button
            val item = itemTv.text.toString()
            val price = priceTv.text.toString()
            val url = urlTv.text.toString()

            val new_wishlist = Wishlist(item, price, url)
            wishlists.add(new_wishlist)

            itemTv.getText().clear()
            priceTv.getText().clear()
            urlTv.getText().clear()

            // Notify the adapter there's new wishlist items so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()

        }
    }
}