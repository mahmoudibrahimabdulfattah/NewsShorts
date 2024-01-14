package com.example.newsshorts.data.remote.entityRespond


val languageItems = listOf(
    "ar", "en",  "fr", "de",
    "es", "he", "it", "nl",
    "pt", "ru", "sv", "ud",
    "zh"
)

val countryItems = listOf(
    "us", "eg", "ae", "ar",
    "at", "au", "be", "bg",
    "br", "ca", "ch", "cn",
    "co", "cu", "cz", "de",
    "fr", "gb", "gr", "hk",
    "hu", "id",
)


data class DropdownMenuItems(
    var text: String
)

data class LanguageItems(
    val ar: String = "ar",
    val en: String = "en",
    val fr: String = "fr",
    val de: String = "de",
    val es: String = "es",
    val he: String = "he",
    val it: String = "it",
    val nl: String = "nl",
    val pt: String = "pt",
    val ru: String = "ru",
    val sv: String = "sv",
    val ud: String = "ud",
    val zh: String = "zh",
)


data class CountryItems(
    val us: String = "us",
    val eg: String = "eg",
    val ae: String = "ae",
    val ar: String = "ar",
    val at: String = "at",
    val au: String = "au",
    val be: String = "be",
    val bg: String = "bg",
    val br: String = "br",
    val ca: String = "ca",
    val ch: String = "ch",
    val cn: String = "cn",
    val co: String = "co",
    val cu: String = "cu",
    val cz: String = "cz",
    val de: String = "de",
    val fr: String = "fr",
    val gb: String = "gb",
    val gr: String = "gr",
    val hk: String = "hk",
    val hu: String = "hu",
    val id: String = "id",
)