package com.example.spaceflightnews.core.di

import com.example.spaceflightnews.core.data.FlightNewsRepository
import com.example.spaceflightnews.core.domain.repository.IFlightNewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: FlightNewsRepository): IFlightNewsRepository
}