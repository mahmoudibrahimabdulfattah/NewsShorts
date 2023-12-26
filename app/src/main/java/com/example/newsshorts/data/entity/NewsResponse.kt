package com.example.newsshorts.data.entity

import kotlinx.serialization.Serializable

data class NewsResponse(
    val status: String?,
    val totalResults: Int,
    val articles: List<Articles>
)

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

data class Source(
    val id: String?,
    val name: String?
)


@Serializable
data class NewsError(
    val status: String? = "status",
    val code: String? = "code",
    val message: String? = "message",
)