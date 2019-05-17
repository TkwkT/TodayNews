package com.example.todaynews.utilities

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object TimeUtils{

    fun stampToDateUrl(stamp:Long):String{
        val simpleDateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val date = Date(stamp)
        val resule = simpleDateFormat.format(date)
        return resule
    }

    fun stampToDate(stamp: Long):String{
        val simpleDateFormat = SimpleDateFormat("yyyy年MM月dd日 E", Locale.getDefault())
        val date = Date(stamp)
        val resule = simpleDateFormat.format(date)
        Log.d("aaa",resule)
        return resule
    }

}