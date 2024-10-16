package com.example.spaceflightnews.core.di

import android.content.Context
import androidx.room.Room
import com.example.spaceflightnews.core.data.source.local.room.FlightNewsDao
import com.example.spaceflightnews.core.data.source.local.room.FlightNewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): FlightNewsDatabase = Room.databaseBuilder(
        context,
        FlightNewsDatabase::class.java, "FlightNews.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideFlightNewsDao(database: FlightNewsDatabase): FlightNewsDao = database.flightNewsDao()
}