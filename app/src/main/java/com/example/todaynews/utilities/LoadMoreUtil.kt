package com.example.todaynews.utilities

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todaynews.adapter.NewsListAdapter
import com.example.todaynews.bean.StoryBean
import com.example.todaynews.repository.NewsListRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList


class LoadMoreUtil{

    private var stamp = 0L
    private val date = Date()
    private val ONE_DAY_MS = 86400000L
    private var isLoading = false

    init {
        stamp = date.time
    }

    fun loadMore(adapter: NewsListAdapter,story:ArrayList<StoryBean>,beforeStory: MutableLiveData<List<StoryBean>>){
        if (!isLoading){
            stamp -= ONE_DAY_MS
            val dateUrl = TimeUtils.stampToDateUrl(stamp)
            val date = TimeUtils.stampToDate(stamp)
            NewsListRepository.getInstance().getZhiHuNewsBeforeService(dateUrl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    isLoading = true
                }
                .doOnNext {
                    val temp = it
                    for (i in 0 until temp.stories.size){
                        temp.stories[i].date = date
                    }
                    temp.stories[0].isFirst = true
                    story.addAll(temp.stories)
                    beforeStory.value = story
                    adapter.freshStoryList(beforeStory.value!!)
                }
                .doOnError {
                    throw it
                }
                .doOnComplete {
                    isLoading = false
                }
                .subscribe()
        }
    }

    companion object {

        @Volatile private var instance: LoadMoreUtil? = null

        fun getInstance() = instance ?: synchronized(this) {
                instance ?: LoadMoreUtil().also { instance = it }
            }
    }


}