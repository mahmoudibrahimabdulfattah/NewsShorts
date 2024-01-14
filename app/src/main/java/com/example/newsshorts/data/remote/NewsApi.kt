package com.example.newsshorts.data.remote

import com.example.newsshorts.util.AppConstants
import com.example.newsshorts.data.remote.entityRespond.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = AppConstants.API_KEY
    ): NewsResponse

    @GET("v2/everything")
    suspend fun getAllNews(
        @Query("q") q: String,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String = AppConstants.API_KEY
    ): NewsResponse
}