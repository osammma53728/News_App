package com.example.meow

import com.example.meow.api.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)