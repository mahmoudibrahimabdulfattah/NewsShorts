package com.example.newsshorts.data.api

import com.example.newsshorts.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "4027ecc1ce6b42338efb883027672f4f"
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun getAllNews(
        @Query("q") q: String,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String = "4027ecc1ce6b42338efb883027672f4f"
    ): Response<NewsResponse>
}