package com.musicode.websearch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_button.setOnClickListener { search() }

        query_input.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                search()
            }
            true
        }
    }

    fun search() {
        val query = query_input.text.toString().trim()
        if (query != "") {
            webview.loadUrl("https://www.baidu.com/s?wd=${query}")
        }
        else {
            Toast.makeText(this, "请输入关键词", Toast.LENGTH_SHORT).show()
        }
    }
}
