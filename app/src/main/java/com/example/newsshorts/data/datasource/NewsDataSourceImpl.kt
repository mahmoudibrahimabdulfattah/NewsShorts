package com.example.newsshorts.data.datasource

import com.example.newsshorts.data.api.ApiService
import com.example.newsshorts.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): NewsDataSource {

    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }

    override suspend fun getAllNews(q: String, language: String): Response<NewsResponse> {
        return apiService.getAllNews(q, language)
    }
}