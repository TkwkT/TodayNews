package com.example.todaynews.viewModel

import android.webkit.WebView
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.example.todaynews.repository.NewsDetailRepository
import com.example.todaynews.utilities.WebViewUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsDetailViewModel(private val repo:NewsDetailRepository) :ViewModel(){

    val isLoading = ObservableBoolean(false)
    val title = ObservableField<String>("")
    private var shareUrl =""
    val progress = ObservableInt(0)

    fun setWebView(webView: WebView){
        WebViewUtil.init(webView,shareUrl,isLoading,progress)
    }

    fun getNewsDetail(id:String,webView: WebView){
        repo.getZhiHuNewsLatestService(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                if (!it.isDisposed){
                    isLoading.set(true)
                }
            }
            .doOnNext {
                shareUrl = it.share_url
                title.set(it.title)
                setWebView(webView)
            }
            .doOnError {
                throw it
            }
            .doOnComplete {
                isLoading.set(false)
            }
            .subscribe()
    }


}