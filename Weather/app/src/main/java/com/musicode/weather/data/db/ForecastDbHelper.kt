package com.musicode.weather.data.db

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.musicode.weather.App
import com.musicode.weather.data.db.schema.CityForecastTable
import com.musicode.weather.data.db.schema.DayForecastTable

class ForecastDbHelper : SQLiteOpenHelper(App.instance, ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    companion object {

        val DB_NAME = "forecast.db"

        val DB_VERSION = 1

        val instance: ForecastDbHelper by lazy {
            ForecastDbHelper()
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table ${CityForecastTable.NAME} (" +
                "${CityForecastTable.ID} integer primary key autoincrement," +
                "${CityForecastTable.CITY}," +
                "${CityForecastTable.COUNTRY}" +
                ")"
        )

        db?.execSQL("CREATE TABLE ${DayForecastTable.NAME} (" +
                "${DayForecastTable.ID} integer primary key autoincrement," +
                "${DayForecastTable.DATE}," +
                "${DayForecastTable.DESCRIPTION}" +
                "${DayForecastTable.HIGH}," +
                "${DayForecastTable.LOW}," +
                "${DayForecastTable.ICON_URL}," +
                "${DayForecastTable.CITY_ID}" +
                ")"
        )

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}