package com.example.todaynews.repository

import com.example.todaynews.bean.NewsBeforeBean
import com.example.todaynews.bean.NewsLatestBean
import com.example.todaynews.http.HttpUtil
import com.example.todaynews.http.ZhiHuBeforeNewsService
import com.example.todaynews.http.ZhiHuNewsLatestService
import io.reactivex.Observable

class NewsListRepository{

    fun getZhiHuNewsBeforeService(date:String): Observable<NewsBeforeBean> {
        return HttpUtil.getBuilder().create(ZhiHuBeforeNewsService::class.java).getBeforeNews(date)
    }

    fun getZhiHuNewsLatestService():Observable<NewsLatestBean>{
        return HttpUtil.getBuilder().create(ZhiHuNewsLatestService::class.java).getLatestNews()
    }

    companion object {

        @Volatile private var instance: NewsListRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: NewsListRepository().also { instance = it }
            }
    }

}