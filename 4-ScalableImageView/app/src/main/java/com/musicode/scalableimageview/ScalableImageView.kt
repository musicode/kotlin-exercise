package com.musicode.scalableimageview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ImageView


class ScalableImageView: ImageView {

    private var isMultiTouch = false

    private var originalX: Float = 0f
    private var originalY: Float = 0f

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        println("image view init")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {

            MotionEvent.ACTION_DOWN -> {
                onTouchDown(event)
            }

            MotionEvent.ACTION_MOVE -> {
                if (isMultiTouch) {
                    onMultiTouchMove(event)
                }
                else {
                    onTouchMove(event)
                }
            }

            MotionEvent.ACTION_UP -> {
                onTouchUp(event)
            }

            MotionEvent.ACTION_POINTER_DOWN -> {
                onMultiTouchDown(event)
            }

            MotionEvent.ACTION_POINTER_UP -> {
                onMultiTouchUp(event)
            }

        }

        return true

    }

    private fun onTouchDown(event: MotionEvent) {
        isMultiTouch = false
        originalX = event.x
        originalY = event.y
    }

    private fun onTouchMove(event: MotionEvent) {
        val offsetX = event.x - originalX
        var offsetY = event.y - originalY

        left += offsetX.toInt()
        right += offsetX.toInt()
        top += offsetY.toInt()
        bottom += offsetY.toInt()

        setFrame(left, top, right, bottom)
    }

    private fun onTouchUp(event: MotionEvent) {

    }

    private fun onMultiTouchDown(event: MotionEvent) {
        isMultiTouch = true
    }

    private fun onMultiTouchMove(event: MotionEvent) {

    }

    private fun onMultiTouchUp(event: MotionEvent) {

    }

}