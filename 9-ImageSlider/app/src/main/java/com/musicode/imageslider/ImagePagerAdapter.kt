package com.musicode.imageslider

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_slider.view.*

class ImagePagerAdapter(private val context: Context, private  val imageList: IntArray) : PagerAdapter() {

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_slider, container, false)
        view.image_view.setImageResource(imageList[position])
        container?.addView(view)

        return view

    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as ConstraintLayout)
    }
}