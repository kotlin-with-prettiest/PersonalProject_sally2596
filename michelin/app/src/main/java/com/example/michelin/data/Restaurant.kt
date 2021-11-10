package com.example.michelin.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val restaurantName: String,
    @ColumnInfo(name = "location")
    val restaurantLocation: String,
    @ColumnInfo(name = "rate")
    val restaurantRate: Double,
)
