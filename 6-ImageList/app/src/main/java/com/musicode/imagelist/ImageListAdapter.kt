package com.musicode.imagelist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.R
import android.widget.ImageView
import android.widget.TextView

class ImageListAdapter(private val imageList: List<Image>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = imageList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.activity_list_item, parent, false)
        ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindImage(imageList[position])
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindImage(image: Image) {
            val imageView = view.findViewById(R.id.icon) as ImageView
            val textView = view.findViewById(R.id.text1) as TextView

            textView.text = image.title
        }
    }

}