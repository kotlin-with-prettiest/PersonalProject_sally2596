package com.example.michelin

import android.app.Application
import com.example.michelin.data.RestaurantRoomDatabase

class RestaurantApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database: RestaurantRoomDatabase by lazy { RestaurantRoomDatabase.getDatabase(this) }
}
