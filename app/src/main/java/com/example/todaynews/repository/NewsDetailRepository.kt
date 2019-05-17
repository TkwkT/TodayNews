package com.example.todaynews.repository

import com.example.todaynews.bean.NewsDetailBean
import com.example.todaynews.http.HttpUtil
import com.example.todaynews.http.ZhiHuNewsDetailService
import io.reactivex.Observable

class NewsDetailRepository {

    fun getZhiHuNewsLatestService(id:String): Observable<NewsDetailBean> {
        return HttpUtil.getBuilder().create(ZhiHuNewsDetailService::class.java).getNewsDetail(id)
    }

    companion object {

        @Volatile private var instance: NewsListRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: NewsListRepository().also { instance = it }
            }
    }

}