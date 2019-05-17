package com.example.todaynews.repository

import com.example.todaynews.bean.NewsBeforeBean
import com.example.todaynews.bean.NewsDetailBean
import com.example.todaynews.bean.NewsLatestBean
import com.example.todaynews.http.HttpUtil
import com.example.todaynews.http.ZhiHuBeforeNewsService
import com.example.todaynews.http.ZhiHuNewsDetailService
import com.example.todaynews.http.ZhiHuNewsLatestService
import io.reactivex.Observable

class ZhiHuRepository{





    fun getZhiHuNewDetailService(id:String):Observable<NewsDetailBean>{
        return HttpUtil.getBuilder().create(ZhiHuNewsDetailService::class.java).getNewsDetail(id)
    }

//    fun getNewsBefore(date: String){
//        NewsBeforeRepository.getInstance(AppDatabase.getInstance(context = ))
//
//
//
//    }
}