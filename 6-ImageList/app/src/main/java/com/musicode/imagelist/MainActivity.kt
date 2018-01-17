package com.musicode.imagelist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val imageList = listOf<Image>(
            Image(R.drawable.img_1, "This is a photo of 1"),
            Image(R.drawable.img_2, "This is a photo of 2"),
            Image(R.drawable.img_3, "This is a photo of 3"),
            Image(R.drawable.img_4, "This is a photo of 4"),
            Image(R.drawable.img_5, "This is a photo of 5"),
            Image(R.drawable.img_6, "This is a photo of 6"),
            Image(R.drawable.img_7, "This is a photo of 7"),
            Image(R.drawable.img_8, "This is a photo of 8"),
            Image(R.drawable.img_9, "This is a photo of 9"),
            Image(R.drawable.img_10, "This is a photo of 10"),
            Image(R.drawable.img_11, "This is a photo of 11"),
            Image(R.drawable.img_12, "This is a photo of 12"),
            Image(R.drawable.img_13, "This is a photo of 13"),
            Image(R.drawable.img_14, "This is a photo of 14"),
            Image(R.drawable.img_15, "This is a photo of 15")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_list.adapter = ImageListAdapter(imageList)
        image_list.layoutManager = LinearLayoutManager(this)

    }
}
