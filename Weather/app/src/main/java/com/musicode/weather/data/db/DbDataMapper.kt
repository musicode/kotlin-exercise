package com.musicode.weather.data.db

import com.musicode.weather.data.db.model.CityForecast
import com.musicode.weather.data.db.model.DayForecast
import com.musicode.weather.domain.model.Forecast
import com.musicode.weather.domain.model.ForecastList

class DbDataMapper {

    private fun convertDayForecastFromDomain(cityId: Long, forecast: Forecast) = with (forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }

    private fun convertDayForecastToDomain(forecast: DayForecast) = with (forecast) {
        Forecast(_id, date, description, high, low, iconUrl)
    }

    fun convertFromDomain(forecast: ForecastList) = with (forecast) {

        val daily = dailyForecast.map { convertDayForecastFromDomain(id, it) }
        CityForecast(id, city, country, daily)
    }

    fun convertToDomain(forecast: CityForecast) = with (forecast) {

        val daily = dailyForecast.map { convertDayForecastToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

}