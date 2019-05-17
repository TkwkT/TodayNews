package com.example.todaynews.viewModel

import android.util.Log
import android.webkit.WebView
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todaynews.bean.NewsBeforeBean
import com.example.todaynews.bean.NewsLatestBean
import com.example.todaynews.bean.StoryBean
import com.example.todaynews.bean.TopStoryBean
import com.example.todaynews.listener.NewsListScrollListener
import com.example.todaynews.repository.NewsListRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsListViewModel(private val repo:NewsListRepository):ViewModel(){

    val latestStory = MutableLiveData<List<TopStoryBean>>()
    val beforeStory = MutableLiveData<List<StoryBean>>()
    val beginLoadingLatest = ObservableBoolean(false)
    val story = ArrayList<StoryBean>()
    val scrollListener = NewsListScrollListener(story,beforeStory)

    fun getLatest(){
        repo.getZhiHuNewsLatestService()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                if (!it.isDisposed) beginLoadingLatest.set(true)
            }
            .doOnNext {
                latestStory.value = it.top_stories
                it.stories[0].isFirst = true
                story.addAll(it.stories)
                beforeStory.value = story
            }
            .doOnError {
                throw it
            }
            .doOnComplete {
                beginLoadingLatest.set(false)
            }
            .subscribe()
    }

}