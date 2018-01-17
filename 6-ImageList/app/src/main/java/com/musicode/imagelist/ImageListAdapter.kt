package com.musicode.imagelist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.os.Bundle

import android.widget.ImageView
import android.widget.TextView

import kotlinx.android.synthetic.main.image_item.view.*

class ImageListAdapter(private val imageList: List<Image>): RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindImage(imageList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.image_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = imageList.size


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindImage(image: Image) {

            view.image_view.setImageResource(image.resourceId)

            view.title_view.text = image.title

        }
    }

}