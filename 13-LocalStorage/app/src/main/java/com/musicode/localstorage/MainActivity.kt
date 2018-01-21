package com.musicode.localstorage

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_button.setOnClickListener {
            val preference = getSharedPreferences("file", Context.MODE_PRIVATE)
            val name = name_value.text.toString()
            val editor = preference.edit()
            editor.putString(name, "login_name")
            editor.apply()
        }

        next_button.setOnClickListener {
            val intent = Intent(this, NameActivity::class.java)
            startActivity(intent)
        }
    }
}
