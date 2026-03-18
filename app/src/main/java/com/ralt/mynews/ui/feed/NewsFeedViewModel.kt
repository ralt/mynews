package com.ralt.mynews.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ralt.mynews.data.model.NewsItem
import com.ralt.mynews.data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsFeedViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(FeedUiState())
    val uiState: StateFlow<FeedUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val cached = repository.getCachedNews()
            if (cached.isNotEmpty()) {
                _uiState.update { it.copy(itemsByTab = groupByTab(cached)) }
            }
            refresh()
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val items = repository.refreshNews()
                _uiState.update { it.copy(itemsByTab = groupByTab(items), isLoading = false) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    private fun groupByTab(items: List<NewsItem>): Map<FeedTab, List<NewsItem>> =
        FeedTab.entries.associateWith { tab ->
            interleaveBySource(items.filter { it.category in tab.categories })
        }

    private fun interleaveBySource(items: List<NewsItem>): List<NewsItem> {
        val bySource = items
            .groupBy { it.source }
            .mapValues { (_, v) -> v.sortedByDescending { it.timestamp }.toMutableList() }
        val queues = bySource.values.toMutableList()
        val result = mutableListOf<NewsItem>()
        while (queues.isNotEmpty()) {
            val iter = queues.iterator()
            while (iter.hasNext()) {
                val queue = iter.next()
                result.add(queue.removeFirst())
                if (queue.isEmpty()) iter.remove()
            }
        }
        return result
    }

    class Factory(private val repository: NewsRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            NewsFeedViewModel(repository) as T
    }
}
