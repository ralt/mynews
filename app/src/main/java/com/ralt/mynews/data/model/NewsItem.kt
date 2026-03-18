package com.ralt.mynews.data.model

data class NewsItem(
    val title: String,
    val summary: String?,
    val url: String,
    val source: String,
    val category: String,
    val timestamp: Long
)
