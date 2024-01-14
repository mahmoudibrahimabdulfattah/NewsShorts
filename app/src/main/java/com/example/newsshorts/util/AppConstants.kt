package com.example.newsshorts.util

import com.example.newsshorts.BuildConfig
import com.example.newsshorts.data.remote.entityRespond.countryItems
import com.example.newsshorts.data.remote.entityRespond.languageItems

object AppConstants {

    const val APP_BASE_URL = "https://newsapi.org/"
    const val q = "*"
    var language: String = languageItems[0] ?: "ar"
    var COUNTRY = countryItems[0] ?: "us"

    var API_KEY = BuildConfig.API_KEY
}