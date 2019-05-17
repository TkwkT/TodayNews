package com.example.todaynews.listener

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaynews.adapter.NewsListAdapter
import com.example.todaynews.bean.StoryBean
import com.example.todaynews.utilities.LoadMoreUtil


class NewsListScrollListener(private val story:ArrayList<StoryBean>, private val beforeStory:MutableLiveData<List<StoryBean>>) :RecyclerView.OnScrollListener(){

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager
        if (layoutManager is LinearLayoutManager) {
            val mLastChildPosition = layoutManager.findLastVisibleItemPosition()//当前页面最后一个可见的item的位置
            val itemTotalCount = layoutManager.itemCount//获取总的item的数量
            Log.d("aaa", "mLastChildPosition:$mLastChildPosition,itemTotalCount:$itemTotalCount")
            if (mLastChildPosition == itemTotalCount - 1) {//当前页面的最后一个item是item全部的最后一个并且当前页面的最后一个item的底部是recycleView的底部的时候，获取新数据
                val adapter = recyclerView.adapter as NewsListAdapter
                LoadMoreUtil.getInstance().loadMore(adapter,story,beforeStory)

            }
        }
    }
}