package com.musicode.weather.domain

interface Command<T> {
    fun execute(): T
}

class RequestForecastCommand(private val zipCode: String): Command<ForecastList> {


    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.exectute())
    }

}