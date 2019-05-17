package com.example.todaynews.viewModel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todaynews.adapter.NewsListAdapter
import com.example.todaynews.bean.NewsBeforeBean
import com.example.todaynews.bean.NewsLatestBean
import com.example.todaynews.bean.StoryBean
import com.example.todaynews.repository.ZhiHuRepository

class StoryViewModel(storyBean: StoryBean):ViewModel(){

    val image  = ObservableField<String>(storyBean.images[0])
    val title =  ObservableField<String>(storyBean.title)
    var isFirst = ObservableBoolean(storyBean.isFirst)
    var date = ObservableField<String>(storyBean.date)

}