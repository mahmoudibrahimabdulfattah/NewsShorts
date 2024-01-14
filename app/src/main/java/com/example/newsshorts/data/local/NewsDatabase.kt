package com.example.newsshorts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ArticlesEntity::class],
    version = 1
)
abstract class NewsDatabase: RoomDatabase() {
    abstract val newsDao: NewsDao
}