package com.example.todaynews.listener

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.todaynews.NewsDetailActivity

class NewsOnClickListener(private val id:Int,private val context: Context) :View.OnClickListener{

    override fun onClick(v: View?) {
        val intent = Intent(context,NewsDetailActivity::class.java)
        intent.putExtra("id",id)
        context.startActivity(intent)
    }

}