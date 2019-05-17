package com.example.todaynews.http

import com.example.todaynews.bean.NewsBeforeBean
import com.example.todaynews.bean.NewsDetailBean
import com.example.todaynews.bean.NewsLatestBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ZhiHuBeforeNewsService{

    @GET("api/4/news/before/{date}")
    fun getBeforeNews(@Path("date")date:String):Observable<NewsBeforeBean>
}

interface ZhiHuNewsLatestService{

    @GET("api/4/news/latest")
    fun getLatestNews():Observable<NewsLatestBean>
}

interface ZhiHuNewsDetailService{

    @GET("api/4/news/{id}")
    fun getNewsDetail(@Path("id")id:String):Observable<NewsDetailBean>
}

