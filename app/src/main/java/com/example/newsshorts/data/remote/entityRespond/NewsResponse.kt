package com.example.newsshorts.data.remote.entityRespond

data class NewsResponse(
    val status: String?,
    val totalResults: Int,
    val articles: List<ArticlesDto>
)

data class ArticlesDto(
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