package com.example.todaynews


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todaynews.adapter.NewsListAdapter
import com.example.todaynews.bean.StoryBean
import com.example.todaynews.databinding.FragmentNewsListBinding
import com.example.todaynews.listener.NewsListScrollListener
import com.example.todaynews.utilities.InjectorUtils
import com.example.todaynews.viewModel.NewsListViewModel
import com.example.todaynews.viewModel.StoryViewModel

class NewsListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNewsListBinding>(inflater,R.layout.fragment_news_list,container,false)

        val adapter = NewsListAdapter()
        binding.newsListRecyclerView.adapter = adapter


        subscribeUi(adapter,binding)

        return binding.root
    }

    private fun subscribeUi(adapter: NewsListAdapter,binding: FragmentNewsListBinding){

        val factory = InjectorUtils.provideNewsListViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(NewsListViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.getLatest()
        binding.newsListRecyclerView.addOnScrollListener(viewModel.scrollListener)
        viewModel.latestStory.observe(viewLifecycleOwner, Observer {result ->
            if (result != null){
                adapter.freshTopList(result)
                binding.newsListRecyclerView.scrollToPosition(0)
            }
        })
        viewModel.beforeStory.observe(viewLifecycleOwner, Observer {
            adapter.freshStoryList(it)
        })


    }


}
