package com.example.newsshorts.data.datasource

import com.example.newsshorts.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadline(country: String): Response<NewsResponse>

    suspend fun getAllNews(q: String, language: String): Response<NewsResponse>
}