package com.example.spaceflightnews.core.data.source.remote

import com.example.spaceflightnews.core.data.NewsType
import com.example.spaceflightnews.core.data.source.remote.network.ApiResponse
import com.example.spaceflightnews.core.data.source.remote.network.ApiService
import com.example.spaceflightnews.core.data.source.remote.response.FlightNewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getNews(type: NewsType): Flow<ApiResponse<List<FlightNewsResponse>>> {
        return flow {
            try {
                val response = when (type) {
                    NewsType.ARTICLE -> apiService.getArticles()
                    NewsType.BLOG -> apiService.getBlogs()
                    NewsType.REPORT -> apiService.getReports()
                }
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}