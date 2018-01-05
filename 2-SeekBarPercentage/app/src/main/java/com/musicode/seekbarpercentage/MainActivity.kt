package com.musicode.seekbarpercentage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.SeekBar

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 输入框的值，折扣可以实时读 SeekBar 的值
    private var value = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateView()

        priceEditText.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                value = priceEditText.text.toString().removePrefix("$").toFloatOrNull() ?: 0f
                updateView()
            }
            // 失焦，类似 js 的里的 blur()
            priceEditText.clearFocus()
            // false 收起键盘
            // true 不收起键盘
            false
        }

        discountSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateView()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }

    fun updateView() {
        val discount = discountSeekBar.progress
        discountValue.text = discount.toString()

        val price = value * (discount / 100f)
        priceValue.text = String.format("%.2f", price)
    }

}
