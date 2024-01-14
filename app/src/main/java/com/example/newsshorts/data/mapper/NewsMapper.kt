package com.example.newsshorts.data.mapper

import com.example.newsshorts.data.remote.entityRespond.ArticlesDto
import com.example.newsshorts.data.local.ArticlesEntity
import com.example.newsshorts.data.local.SourceEntity
import com.example.newsshorts.data.remote.entityRespond.SourceDto
import com.example.newsshorts.domain.model.Articles
import com.example.newsshorts.domain.model.Source

fun SourceDto.toSourceEntity():SourceEntity{
    return SourceEntity(
        id = id ?: "",
        name = name ?: ""
    )
}

fun ArticlesDto.toArticlesEntity(): ArticlesEntity{
    return ArticlesEntity(
        author = author ?: "",
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: "",
        publishedAt = publishedAt ?: "",
        content = content ?: "",

        source = source!!.toSourceEntity()
    )
}


fun SourceEntity.toSource(): Source{
    return Source(
        id = id,
        name = name
    )
}

fun ArticlesEntity.toArticle(): Articles{
    return Articles(
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content,

        source = source.toSource()
    )
}