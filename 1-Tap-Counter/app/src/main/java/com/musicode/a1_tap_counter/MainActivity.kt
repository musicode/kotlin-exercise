package com.musicode.a1_tap_counter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateNumber()

        tap_button.setOnClickListener {
            currentNumber++
            updateNumber()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.reset_button -> {
                currentNumber = 0
                updateNumber()
            }
            else -> {
                println("item not found")
            }
        }

        return super.onOptionsItemSelected(item)
    }


    fun updateNumber() {
        number_text_view.text = currentNumber.toString()
    }
}
