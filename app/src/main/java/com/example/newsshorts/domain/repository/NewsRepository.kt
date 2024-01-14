package com.example.newsshorts.domain.repository

import com.example.newsshorts.domain.model.Articles
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadline(
        forceFetchFromRemote: Boolean,
        country: String
    ): Flow<ResourceState<List<Articles>>>

    suspend fun getAllNews(q: String, language: String): Flow<ResourceState<List<Articles>>>
}