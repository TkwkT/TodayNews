package com.example.todaynews.bean

data class NewsLatestBean(
    val date: String,
    val stories: List<StoryBean>,
    val top_stories: List<TopStoryBean>
)
