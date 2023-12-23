package com.example.newsinshort.data.datasource

import com.example.newsinshort.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadline(country: String): Response<NewsResponse>

    suspend fun getAllNews(q: String): Response<NewsResponse>
}