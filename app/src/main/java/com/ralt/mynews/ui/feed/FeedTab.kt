package com.ralt.mynews.ui.feed

enum class FeedTab(val label: String, val categories: Set<String>) {
    TECH("Tech", setOf("Tech", "Linux")),
    WORLD("World", setOf("World")),
    FINANCE("Finance", setOf("Finance")),
    FRANCE("France", setOf("French", "Local"))
}
