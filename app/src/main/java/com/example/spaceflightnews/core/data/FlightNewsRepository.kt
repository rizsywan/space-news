package com.example.spaceflightnews.core.data

import com.example.spaceflightnews.core.data.source.local.LocalDataSource
import com.example.spaceflightnews.core.data.source.remote.RemoteDataSource
import com.example.spaceflightnews.core.data.source.remote.network.ApiResponse
import com.example.spaceflightnews.core.data.source.remote.response.FlightNewsResponse
import com.example.spaceflightnews.core.domain.model.FlightNews
import com.example.spaceflightnews.core.domain.repository.IFlightNewsRepository
import com.example.spaceflightnews.core.utils.AppExecutors
import com.example.spaceflightnews.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlightNewsRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : IFlightNewsRepository {

    override fun getNews(type: NewsType): Flow<Resource<List<FlightNews>>> {
        return object : NetworkBoundResource<List<FlightNews>, List<FlightNewsResponse>>(type) {
            override fun loadFromDB(): Flow<List<FlightNews>> {
                return localDataSource.getAllNews().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(type: NewsType): Flow<ApiResponse<List<FlightNewsResponse>>> {
                return remoteDataSource.getNews(type)
            }

            override suspend fun saveCallResult(data: List<FlightNewsResponse>) {
                val tourismList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertFlightNews(tourismList)
            }

            override fun shouldFetch(data: List<FlightNews>?): Boolean {
                return data.isNullOrEmpty()
            }
        }.asFlow()
    }

    override fun getFavoriteNews(): Flow<List<FlightNews>> {
        return localDataSource.getFavoriteNews().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteNews(news: FlightNews, state: Boolean) {
        val flightNewsEntity = DataMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setFavoriteNews(flightNewsEntity, state) }
    }
}