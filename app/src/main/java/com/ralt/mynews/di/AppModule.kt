package com.ralt.mynews.di

import android.content.Context
import com.prof18.rssparser.RssParser
import com.ralt.mynews.data.local.NewsDatabase
import com.ralt.mynews.data.remote.RssDataSource
import com.ralt.mynews.data.repository.NewsRepository

class AppModule(context: Context) {
    private val database by lazy { NewsDatabase.create(context) }
    private val rssParser by lazy { RssParser() }
    private val rssDataSource by lazy { RssDataSource(rssParser) }
    val newsRepository by lazy { NewsRepository(rssDataSource, database.newsDao()) }
}
