package com.example.newsinshort.data.api

import com.example.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "22e6a1a962eb42519f47eb018cc95bc9"
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun getAllNews(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String = "22e6a1a962eb42519f47eb018cc95bc9"
    ): Response<NewsResponse>
}