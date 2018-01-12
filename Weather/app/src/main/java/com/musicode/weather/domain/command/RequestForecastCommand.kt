package com.musicode.weather.domain.command

import com.musicode.weather.data.server.ServerDataMapper
import com.musicode.weather.domain.ForecastRequest
import com.musicode.weather.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ServerDataMapper().convertFromDataModel(forecastRequest.exectute())
    }

}