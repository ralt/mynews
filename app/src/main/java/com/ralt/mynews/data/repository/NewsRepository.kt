package com.ralt.mynews.data.repository

import com.ralt.mynews.data.local.NewsDao
import com.ralt.mynews.data.local.NewsEntity
import com.ralt.mynews.data.model.NewsItem
import com.ralt.mynews.data.remote.RssDataSource
import com.ralt.mynews.data.remote.feedSources
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class NewsRepository(
    private val rssDataSource: RssDataSource,
    private val newsDao: NewsDao
) {
    suspend fun getCachedNews(): List<NewsItem> =
        newsDao.getAll().map { it.toNewsItem() }

    suspend fun refreshNews(): List<NewsItem> = coroutineScope {
        val results = feedSources.map { source ->
            async {
                try {
                    rssDataSource.fetch(source)
                } catch (e: Exception) {
                    emptyList()
                }
            }
        }.awaitAll()

        val allItems = results.flatten()

        // Cache results
        newsDao.upsertAll(allItems.map { NewsEntity.fromNewsItem(it) })

        // Delete items older than 48 hours
        val cutoff = System.currentTimeMillis() - 48 * 60 * 60 * 1000
        newsDao.deleteOlderThan(cutoff)

        newsDao.getAll().map { it.toNewsItem() }
    }
}
