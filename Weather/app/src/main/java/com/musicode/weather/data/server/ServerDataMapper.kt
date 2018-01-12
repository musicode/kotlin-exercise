package com.musicode.weather.data.server

import com.musicode.weather.domain.model.Forecast as ModelForecast
import com.musicode.weather.domain.model.ForecastList as ModelForecastList

class ServerDataMapper {

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/${iconCode}.png"

    fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    fun convertForecastItemToDomain(forecast: Forecast) = with (forecast) {
        ModelForecast(-1,
            dt,
            weather[0].description,
            temp.max.toInt(),
            temp.min.toInt(),
            generateIconUrl(weather[0].icon)
        )
    }

    fun convertFromDataModel(forecastResult: ForecastResult) = with (forecastResult) {
        ModelForecastList(
            city.id,
            city.name,
            city.country,
            convertForecastListToDomain(list)
        )
    }

}