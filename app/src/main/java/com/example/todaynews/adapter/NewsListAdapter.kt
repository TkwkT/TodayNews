package com.example.todaynews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todaynews.R
import com.example.todaynews.bean.StoryBean
import com.example.todaynews.bean.TopStoryBean
import com.example.todaynews.databinding.NewsListNewsItemBinding
import com.example.todaynews.databinding.NewsViewPagerBinding
import com.example.todaynews.holder.*

class NewsListAdapter :RecyclerView.Adapter<BaseHolder>(){

    private val topNews = ArrayList<TopStoryBean>()

    private val TYPE_NEWS = 1
    private val TYPE_TOP = 2

    private val mDiffer = AsyncListDiffer<StoryBean>(this, object :DiffUtil.ItemCallback<StoryBean>(){

        override fun areItemsTheSame(oldItem: StoryBean, newItem: StoryBean): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: StoryBean, newItem: StoryBean): Boolean {
            return oldItem.id == newItem.id
        }
    })

    fun freshTopList(list:List<TopStoryBean>){
        topNews.clear()
        topNews.addAll(list)
    }

    fun freshStoryList(list: List<StoryBean>){
        mDiffer.submitList(list)
        notifyDataSetChanged()
    }

    fun getItem(position: Int):StoryBean{
        return mDiffer.currentList[position - 1]
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size + 1
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        when(holder){
            is TopStoryHolder -> holder.bind(TopStorySource(topNews))
            else -> holder.bind(NewsListSource(getItem(position)))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val topBinding = DataBindingUtil.inflate<NewsViewPagerBinding>(LayoutInflater.from(parent.context),R.layout.news_view_pager,parent,false)
        val storyBinding = DataBindingUtil.inflate<NewsListNewsItemBinding>(LayoutInflater.from(parent.context), R.layout.news_list_news_item,parent,false)
        return when (viewType){
            TYPE_TOP -> TopStoryHolder(topBinding)
            else -> NewsListHolder(storyBinding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_TOP
            else -> TYPE_NEWS
        }
    }
}
