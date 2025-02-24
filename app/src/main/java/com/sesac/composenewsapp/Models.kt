package com.sesac.composenewsapp

// 뉴스 데이터 모델
data class NewsResponse(val articles: List<Article>)
data class Article(
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?
)
