package com.example.todaynews.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todaynews.repository.NewsDetailRepository
import com.example.todaynews.repository.NewsListRepository

class NewsDetailViewModelFactory(private val repository: NewsDetailRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsDetailViewModel(repository) as T
    }
}