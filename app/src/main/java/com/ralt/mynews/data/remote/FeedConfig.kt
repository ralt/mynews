package com.ralt.mynews.data.remote

data class FeedSource(
    val name: String,
    val url: String,
    val category: String
)

val feedSources = listOf(
    FeedSource("Hacker News", "https://news.ycombinator.com/rss", "Tech"),
    FeedSource("r/programming", "https://www.reddit.com/r/programming/.rss", "Tech"),
    FeedSource("Ars Technica", "https://feeds.arstechnica.com/arstechnica/index", "Tech"),
    FeedSource("BBC World", "https://feeds.bbci.co.uk/news/world/rss.xml", "World"),
    FeedSource("r/worldnews", "https://www.reddit.com/r/worldnews/.rss", "World"),
    FeedSource("Reuters", "https://www.reutersagency.com/feed/", "World"),
    FeedSource("Al Jazeera", "https://www.aljazeera.com/xml/rss/all.xml", "World"),
    FeedSource("Le Monde", "https://www.lemonde.fr/rss/une.xml", "French"),
    FeedSource("France Info", "https://www.francetvinfo.fr/titres.rss", "French"),
    FeedSource("France Bleu Vaucluse", "https://www.francebleu.fr/rss/vaucluse.xml", "Local"),
    FeedSource("Google News Local", "https://news.google.com/rss/search?q=Orange+Vaucluse+OR+Mornas&hl=fr&gl=FR&ceid=FR:fr", "Local"),
    FeedSource("Les Echos", "https://syndication.lesechos.fr/rss/rss_une.xml", "Finance"),
    FeedSource("CNBC", "https://search.cnbc.com/rs/search/combinedcms/view.xml?partnerId=wrss01&id=10001147", "Finance"),
    FeedSource("MarketWatch", "https://feeds.marketwatch.com/marketwatch/topstories/", "Finance"),
    FeedSource("LWN.net", "https://lwn.net/headlines/rss", "Linux")
)
