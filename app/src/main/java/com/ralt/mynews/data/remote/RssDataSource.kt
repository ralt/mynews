package com.ralt.mynews.data.remote

import com.prof18.rssparser.RssParser
import com.ralt.mynews.data.model.NewsItem
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class RssDataSource(private val rssParser: RssParser) {

    suspend fun fetch(source: FeedSource): List<NewsItem> {
        val channel = rssParser.getRssChannel(source.url)
        return channel.items.mapNotNull { item ->
            val url = item.link ?: return@mapNotNull null
            val title = item.title ?: return@mapNotNull null
            if (source.name == "Hacker News" && title.startsWith("Ask HN: Who is hiring")) return@mapNotNull null
            NewsItem(
                title = title,
                summary = item.description?.take(300),
                url = url,
                source = source.name,
                category = source.category,
                timestamp = parseDate(item.pubDate)
            )
        }
    }

    private fun parseDate(dateStr: String?): Long {
        if (dateStr == null) return System.currentTimeMillis()
        return try {
            ZonedDateTime.parse(dateStr, DateTimeFormatter.RFC_1123_DATE_TIME)
                .toInstant().toEpochMilli()
        } catch (_: Exception) {
            try {
                ZonedDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME)
                    .toInstant().toEpochMilli()
            } catch (_: Exception) {
                System.currentTimeMillis()
            }
        }
    }
}
