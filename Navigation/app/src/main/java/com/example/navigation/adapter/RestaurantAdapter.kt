package com.example.navigation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.RestaurantListFragmentDirections
import com.example.navigation.model.Restaurant

class RestaurantAdapter(
    private val context: Context,
    private val dataset: List<Restaurant>
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {


    class RestaurantViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val restNameView = view.findViewById<TextView>(R.id.rest_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.restaurant_list_item, parent, false)
        return RestaurantViewHolder(layout)
    }


    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = dataset[position]
        val name = context.resources.getString(item.restaurantName)
        holder.restNameView.text = name

        holder.restNameView.setOnClickListener{
            val action = RestaurantListFragmentDirections.actionRestaurantListFragmentToRestaurantDetailFragment(name)
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = dataset.size
}