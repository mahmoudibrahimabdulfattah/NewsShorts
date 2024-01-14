package com.example.newsshorts.data.mapper

import com.example.newsshorts.data.remote.entityRespond.ArticlesDto
import com.example.newsshorts.data.local.ArticlesEntity
import com.example.newsshorts.domain.model.Articles

fun ArticlesDto.toArticlesEntity(): ArticlesEntity{
    return ArticlesEntity(
        source = source,
        author = author ?: "",
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: "",
        publishedAt = publishedAt ?: "",
        content = content ?: ""
    )
}

fun ArticlesEntity.toArticle(): Articles{
    return Articles(
        source = source,
        author = author ?: "",
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: "",
        publishedAt = publishedAt ?: "",
        content = content ?: ""
    )
}