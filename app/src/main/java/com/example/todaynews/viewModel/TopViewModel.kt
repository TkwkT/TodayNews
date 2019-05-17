package com.example.todaynews.viewModel

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.example.todaynews.bean.TopStoryBean

class TopViewModel(topStoryBean: TopStoryBean) :ViewModel(){

    val id = ObservableInt(topStoryBean.id)
    val image = ObservableField<String>(topStoryBean.image)
    val title = ObservableField<String>(topStoryBean.title)

}