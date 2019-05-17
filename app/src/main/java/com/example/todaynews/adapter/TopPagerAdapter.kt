package com.example.todaynews.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.example.todaynews.R
import com.example.todaynews.bean.TopStoryBean
import com.example.todaynews.databinding.NewsViewPagerItemBinding
import com.example.todaynews.listener.NewsOnClickListener
import com.example.todaynews.viewModel.TopViewModel

class TopPagerAdapter(private val topStoryBean:List<TopStoryBean>,private val context: Context): PagerAdapter(){

    override fun isViewFromObject(view: View, any: Any): Boolean {
        val binding = any as NewsViewPagerItemBinding
        return view == binding.root
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = DataBindingUtil.inflate<NewsViewPagerItemBinding>(LayoutInflater.from(container.context), R.layout.news_view_pager_item,container,false)
        binding.viewmodel = TopViewModel(topStoryBean[position])
        binding.clickListener = NewsOnClickListener(topStoryBean[position].id,context)
        container.addView(binding.root)
        binding.executePendingBindings()
        return binding
    }

    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {

    }

    override fun getCount(): Int {
       return topStoryBean.size
    }


}