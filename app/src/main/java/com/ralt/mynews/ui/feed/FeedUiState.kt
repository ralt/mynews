package com.ralt.mynews.ui.feed

import com.ralt.mynews.data.model.NewsItem

data class FeedUiState(
    val itemsByTab: Map<FeedTab, List<NewsItem>> = emptyMap(),
    val isLoading: Boolean = false,
    val error: String? = null
)
