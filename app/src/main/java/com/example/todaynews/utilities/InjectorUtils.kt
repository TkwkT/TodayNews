package com.example.todaynews.utilities

import com.example.todaynews.repository.NewsDetailRepository
import com.example.todaynews.repository.NewsListRepository
import com.example.todaynews.viewModel.NewsDetailViewModelFactory
import com.example.todaynews.viewModel.NewsListViewModelFactory

object InjectorUtils {

    fun getNewsListRepository():NewsListRepository{
        return NewsListRepository.getInstance()
    }

    fun provideNewsListViewModelFactory():NewsListViewModelFactory{
        val repository = getNewsListRepository()
        return NewsListViewModelFactory(repository)
    }

    fun getNewsDetailRepository():NewsDetailRepository{
        return NewsDetailRepository()
    }

    fun provideNewsDetailViewModelFactory():NewsDetailViewModelFactory{
        val repository = getNewsDetailRepository()
        return NewsDetailViewModelFactory(repository)
    }

}