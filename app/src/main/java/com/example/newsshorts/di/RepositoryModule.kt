package com.example.newsshorts.di

import com.example.newsshorts.data.repository.NewsRepositoryImpl
import com.example.newsshorts.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMovieListRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}