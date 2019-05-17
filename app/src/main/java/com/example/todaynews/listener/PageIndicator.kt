package com.example.todaynews.listener

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.example.todaynews.R
import com.example.todaynews.repository.NewsListRepository


class PageIndicator(context: Context, linearLayout: LinearLayout) : ViewPager.OnPageChangeListener{
    private val mImgList: List<ImageView>//保存img总个数
    private val img_select: Int
    private val img_unSelect: Int

    init {

        mImgList = ArrayList()
        img_select = R.drawable.dot_white_sharp_drawable
        img_unSelect = R.drawable.dot_gray_sharp_drawable
        val imgSize = 20

        for (i in 0 until 5) {
            val imageView = ImageView(context)
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            )

            params.leftMargin = 10
            params.rightMargin = 10

            params.height = imgSize
            params.width = imgSize
            if (i == 0) {
                imageView.setBackgroundResource(img_select)
            } else {
                imageView.setBackgroundResource(img_unSelect)
            }
            linearLayout.addView(imageView, params)
            mImgList.add(imageView)
        }


    }

    companion object {

        @Volatile private var instance: PageIndicator? = null

        fun getInstance(context: Context, linearLayout: LinearLayout) =
            instance ?: synchronized(this) {
                instance ?: PageIndicator(context,linearLayout).also { instance = it }
            }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        for (i in 0 until 5) {
            //选中的页面改变小圆点为选中状态，反之为未选中
            if (position % 5 == i) {
                mImgList[i].setBackgroundResource(img_select)
            } else {
                mImgList[i].setBackgroundResource(img_unSelect)
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {}
}
