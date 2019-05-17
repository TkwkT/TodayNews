package com.example.todaynews.http

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpUtil{

    fun getBuilder():Retrofit{
        val client = OkHttpClient.Builder()
            .callTimeout(8,TimeUnit.SECONDS)
            .readTimeout(8,TimeUnit.SECONDS)
            .connectTimeout(8,TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://news-at.zhihu.com/")
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}