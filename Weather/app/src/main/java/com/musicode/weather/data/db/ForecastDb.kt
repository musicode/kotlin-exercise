package com.musicode.weather.data.db

import com.musicode.weather.domain.ForecastDataMapper

class ForecastDb {

    val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance

    val dataMapper: ForecastDataMapper = ForecastDataMapper()
}