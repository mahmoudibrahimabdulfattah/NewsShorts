package com.example.newsshorts.domain.model

import com.example.newsshorts.data.remote.entityRespond.Source

data class Articles(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
