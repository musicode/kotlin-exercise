package com.musicode.weather.domain

import com.musicode.weather.domain.Forecast as ModelForecast
import com.musicode.weather.data.Forecast
import com.musicode.weather.data.ForecastResult
import java.text.DateFormat
import java.util.*

public class ForecastDataMapper {

    private fun convertDate(date: Long): String {

        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())

        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String {
        return "http://openweathermap.org/img/w/$iconCode.png"
    }

    fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
                convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon)
        )
    }

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(
                forecast.city.name,
                forecast.city.country,
                convertForecastListToDomain(forecast.list)
        )
    }
}