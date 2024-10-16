package com.example.spaceflightnews.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.spaceflightnews.core.data.source.local.entity.FlightNewsEntity

@Database(entities = [FlightNewsEntity::class], version = 1, exportSchema = false)
abstract class FlightNewsDatabase: RoomDatabase() {
    abstract fun flightNewsDao(): FlightNewsDao
}