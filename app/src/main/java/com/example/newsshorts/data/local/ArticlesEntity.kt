package com.example.newsshorts.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticlesEntity(
    val source: SourceEntity,
    val author: String,
    @PrimaryKey
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)


@Entity
data class SourceEntity(
    val id: String,
    val name: String
)