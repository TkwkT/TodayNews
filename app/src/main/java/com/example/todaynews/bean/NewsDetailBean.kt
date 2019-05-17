package com.example.todaynews.bean

data class NewsDetailBean(
    val body: String,
    val css: List<String>,
    val id: Int,
    val image: String,
    val image_source: String,
    val share_url: String,
    val title: String
)