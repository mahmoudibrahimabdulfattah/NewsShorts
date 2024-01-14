package com.example.newsshorts.data.repository

import com.example.newsshorts.data.remote.NewsApi
import com.example.newsshorts.data.local.NewsDatabase
import com.example.newsshorts.domain.model.Articles
import com.example.newsshorts.domain.repository.NewsRepository
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    newsApi: NewsApi,
    newsDatabase: NewsDatabase
): NewsRepository {
    override suspend fun getNewsHeadline(
        forceFetchFromRemote: Boolean,
        country: String
    ): Flow<ResourceState<List<Articles>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllNews(
        q: String,
        language: String
    ): Flow<ResourceState<List<Articles>>> {
        TODO("Not yet implemented")
    }
}