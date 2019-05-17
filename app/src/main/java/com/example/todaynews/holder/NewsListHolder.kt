package com.example.todaynews.holder

import com.example.todaynews.bean.StoryBean
import com.example.todaynews.databinding.NewsListNewsItemBinding
import com.example.todaynews.listener.NewsOnClickListener
import com.example.todaynews.viewModel.StoryViewModel

class NewsListHolder(private val binding: NewsListNewsItemBinding): BaseHolder(binding){

    override fun <T> bind(t: T) {
        if (t is NewsListSource){
            binding.viewmodel = StoryViewModel(t.storyBean)
            binding.clickListener = NewsOnClickListener(t.storyBean.id,context)
            binding.executePendingBindings()
        }
    }
}

data class NewsListSource(
    val storyBean: StoryBean
)
