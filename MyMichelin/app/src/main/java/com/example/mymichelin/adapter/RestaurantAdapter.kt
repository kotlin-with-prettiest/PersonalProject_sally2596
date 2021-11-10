package com.example.mymichelin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymichelin.R
import com.example.mymichelin.model.Restaurant

class RestaurantAdapter(
    private val context: Context,
    private val dataset: List<Restaurant>
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val restNameView: TextView = view.findViewById(R.id.rest_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_list_item, parent, false)

        return RestaurantViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = dataset[position]
        holder.restNameView.text = context.resources.getString(item.restaurantName)
    }

    override fun getItemCount() = dataset.size
}