package com.example.newsshorts.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NewsDao {
    @Upsert
    suspend fun upsertNewsList(newsList: List<ArticlesEntity>)

    @Query("SELECT * FROM ArticlesEntity WHERE title = :title")
    suspend fun getMovieByTitle(title: String): ArticlesEntity

}