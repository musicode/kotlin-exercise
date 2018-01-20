package com.musicode.activityschedule

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val cal = Calendar.getInstance()

    private val dateSetListener = DatePickerDialog.OnDateSetListener{ view, year, month, date ->
        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, month)
        cal.set(Calendar.DATE, date)

        date_value.text = formatDate("yyyy-MM-dd")
    }

    private val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
        // HOUR_OF_DAY 是 24 小时制
        // HOUR 是 12 小时制
        cal.set(Calendar.HOUR_OF_DAY, hour)
        cal.set(Calendar.MINUTE, minute)

        time_value.text = formatDate("HH:mm")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date_value.setOnClickListener {
            DatePickerDialog(
                    this,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DATE)
            ).show()
        }

        time_value.setOnClickListener {
            TimePickerDialog(
                    this,
                    timeSetListener,
                    cal.get(Calendar.HOUR_OF_DAY),
                    cal.get(Calendar.MINUTE),
                    true
            ).show()
        }

        go_button.setOnClickListener {

            val time = formatDate("yyyy-MM-dd HH:mm")

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Party time confirm")
            builder.setMessage(time)

            builder.setPositiveButton("Confirm", { dialog, whichButton ->
                println("confirm")
            })

            builder.setNegativeButton("Cancel", { dialog, whichButton ->
                println("cancel")
            })

            builder.create().show()

        }
    }

    private fun formatDate(pattern: String): String {
        val time = SimpleDateFormat(pattern, Locale.CHINA)
        return time.format(cal.time)
    }

}
