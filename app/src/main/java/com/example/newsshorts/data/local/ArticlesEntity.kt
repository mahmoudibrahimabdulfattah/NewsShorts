package com.example.newsshorts.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsshorts.data.remote.entityRespond.Source

@Entity
data class ArticlesEntity(
    val source: Source?,
    val author: String?,

    @PrimaryKey
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
