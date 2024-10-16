package com.example.spaceflightnews.core.data.source.remote.network

import com.example.spaceflightnews.core.data.source.remote.response.FlightNewsListResponse
import retrofit2.http.GET

interface ApiService {
    @GET("articles")
    suspend fun getArticles(): FlightNewsListResponse

    @GET("blogs")
    suspend fun getBlogs(): FlightNewsListResponse

    @GET("reports")
    suspend fun getReports(): FlightNewsListResponse
}