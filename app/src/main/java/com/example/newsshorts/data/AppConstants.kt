package com.example.newsshorts.data

import com.example.newsshorts.data.entity.countryItems
import com.example.newsshorts.data.entity.languageItems

object AppConstants {

    const val APP_BASE_URL = "https://newsapi.org/"
    const val q = "*"
    var language: String = languageItems[0] ?: "ar"
    var COUNTRY = countryItems[0] ?: "us"
}