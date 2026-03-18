package com.ralt.mynews.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ralt.mynews.data.model.NewsItem

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey val url: String,
    val title: String,
    val summary: String?,
    val source: String,
    val category: String,
    val timestamp: Long
) {
    fun toNewsItem() = NewsItem(
        title = title,
        summary = summary,
        url = url,
        source = source,
        category = category,
        timestamp = timestamp
    )

    companion object {
        fun fromNewsItem(item: NewsItem) = NewsEntity(
            url = item.url,
            title = item.title,
            summary = item.summary,
            source = item.source,
            category = item.category,
            timestamp = item.timestamp
        )
    }
}
