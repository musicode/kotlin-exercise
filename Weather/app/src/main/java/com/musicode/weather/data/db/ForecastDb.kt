package com.musicode.weather.data.db

import com.musicode.weather.data.server.ServerDataMapper


class ForecastDb {

    val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance

    val dataMapper: ServerDataMapper = ServerDataMapper()


}