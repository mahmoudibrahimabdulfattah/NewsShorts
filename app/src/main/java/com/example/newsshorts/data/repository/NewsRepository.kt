package com.example.newsshorts.data.repository

import com.example.newsshorts.data.datasource.NewsDataSource
import com.example.newsshorts.data.entity.NewsResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject


class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
){

    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(country)

            if(response.isSuccessful && response.body() != null){
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error(response.errorBody()?.string().toString()))
            }

        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Error flow"))
        }
    }

    suspend fun getAllNews(q: String, language: String): Flow<ResourceState<NewsResponse>>{
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getAllNews(q, language)

            if(response.isSuccessful && response.body() != null){
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error(response.errorBody()?.string().toString()))
            }

        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Error flow"))
        }
    }
}