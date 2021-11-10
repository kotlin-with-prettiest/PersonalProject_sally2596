package com.example.recyclerview.data

import com.example.recyclerview.R
import com.example.recyclerview.model.Restaurant

class Datasource {
    fun loadRestaurant():List<Restaurant>{
        return listOf<Restaurant>(
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
        )
    }
}