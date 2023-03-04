package com.example.wishlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishlists: List<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        init {
            itemTextView = itemView.findViewById(R.id.itemTv)
            priceTextView = itemView.findViewById(R.id.priceTv)
            urlTextView = itemView.findViewById(R.id.urlTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishlist = wishlists.get(position)
        // Set item views based on views and data model
        holder.itemTextView.text = wishlist.item
        holder.priceTextView.text = wishlist.price
        holder.urlTextView.text = wishlist.url
    }

    override fun getItemCount(): Int {
        return wishlists.size
    }

}