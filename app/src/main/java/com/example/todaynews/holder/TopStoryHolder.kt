package com.example.todaynews.holder

import android.view.LayoutInflater
import com.example.todaynews.adapter.TopPagerAdapter
import com.example.todaynews.bean.TopStoryBean
import com.example.todaynews.databinding.NewsViewPagerBinding
import com.example.todaynews.listener.PageIndicator

class TopStoryHolder(private val binding: NewsViewPagerBinding):BaseHolder(binding){

    override fun <T> bind(t: T) {
        if ( t is TopStorySource){
            val pagerAdapter = TopPagerAdapter(t.topStoryBean,context)
            binding.newsPager.adapter = pagerAdapter
            binding.newsPager.addOnPageChangeListener(PageIndicator.getInstance(context,binding.dotLayout))
        }
    }
}

data class TopStorySource(
    val topStoryBean: List<TopStoryBean>
)

