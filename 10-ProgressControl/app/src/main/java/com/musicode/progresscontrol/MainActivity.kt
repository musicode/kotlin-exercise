package com.musicode.progresscontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var value = 0

    var maxValue = 100

    var delayTime = 500L

    val taskHandler = Handler()

    val runnable = object: Runnable {
        override fun run() {
            start()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button.setOnClickListener { start() }
        pause_button.setOnClickListener { pause() }
        stop_button.setOnClickListener { stop() }

        progress_bar.max = maxValue
        progress_bar.progress = 0

    }

    fun start() {
        if (value < maxValue) {
            value += 10
            update()

            taskHandler.postDelayed(runnable, delayTime)
        }
        else {
            pause()
        }
    }

    fun pause() {
        taskHandler.removeCallbacksAndMessages(null)
    }

    fun stop() {
        pause()
        value = 0
        update()
    }

    fun update() {
        progress_bar.progress = value
        progress_text.text = "${value}%"
    }
}
