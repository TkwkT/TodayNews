package com.example.todaynews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.todaynews.databinding.ActivityNewsDetailBinding
import com.example.todaynews.utilities.InjectorUtils
import com.example.todaynews.viewModel.NewsDetailViewModel

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra("id",0)

        val binding = DataBindingUtil.setContentView<ActivityNewsDetailBinding>(this,R.layout.activity_news_detail)
        binding.viewmodel
        init(binding,id)
    }

    private fun init(binding: ActivityNewsDetailBinding,id:Int){
        val factory = InjectorUtils.provideNewsDetailViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(NewsDetailViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.getNewsDetail(id.toString(),binding.webView)
        binding.mainActivityToolbar.setNavigationOnClickListener {
            finish()
        }
    }

}
