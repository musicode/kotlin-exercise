package com.musicode.localstorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        name_button.setOnClickListener {


            val preference = getSharedPreferences("file", Context.MODE_PRIVATE)

            Toast.makeText(this, preference.getString("login_name", ""), Toast.LENGTH_SHORT).show()


        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
