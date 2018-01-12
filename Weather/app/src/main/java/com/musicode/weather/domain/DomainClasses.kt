package com.musicode.weather.domain


data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size
}

