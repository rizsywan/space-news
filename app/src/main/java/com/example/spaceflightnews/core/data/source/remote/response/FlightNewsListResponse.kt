package com.example.spaceflightnews.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class FlightNewsListResponse(
    @SerializedName("results")
    val results: List<FlightNewsResponse>
)