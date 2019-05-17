package com.example.todaynews.bean

data class StoryBean(
    val id: Int,
    val images: List<String>,
    val title: String,
    var isFirst:Boolean = false,
    var date:String = "今日新闻"
)