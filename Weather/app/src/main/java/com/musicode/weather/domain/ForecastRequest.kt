package com.musicode.weather.domain

import com.google.gson.Gson
import com.musicode.weather.data.server.ForecastResult
import java.net.URL

class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&zip="
    }

    fun exectute(): ForecastResult {
        val jsonStr = URL(COMPLETE_URL + zipCode).readText()
        /**
         *
         * 返回结果示例：
         *
         * {"city":{"id":0,"name":"Mountain View","coord":{"lon":-122.0775,"lat":37.4056},"country":"US","population":0},"cod":"200","message":2.8278509,"cnt":7,"list":[{"dt":1515700800,"temp":{"day":10.29,"min":10.29,"max":10.29,"night":10.29,"eve":10.29,"morn":10.29},"pressure":1002.03,"humidity":97,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"speed":1.28,"deg":355,"clouds":76},{"dt":1515787200,"temp":{"day":16.83,"min":2.91,"max":16.83,"night":2.91,"eve":7.32,"morn":9.51},"pressure":1000.91,"humidity":76,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":1.37,"deg":349,"clouds":0},{"dt":1515873600,"temp":{"day":17.32,"min":1.35,"max":17.32,"night":6.42,"eve":9.72,"morn":1.35},"pressure":996.59,"humidity":66,"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02d"}],"speed":1.52,"deg":55,"clouds":20},{"dt":1515960000,"temp":{"day":18.86,"min":6.13,"max":18.86,"night":7.43,"eve":10.21,"morn":6.13},"pressure":995.86,"humidity":67,"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02d"}],"speed":1.41,"deg":83,"clouds":12},{"dt":1516046400,"temp":{"day":12.75,"min":8,"max":16.04,"night":10.75,"eve":16.04,"morn":8},"pressure":1015.01,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":1.82,"deg":78,"clouds":28,"rain":0.32},{"dt":1516132800,"temp":{"day":12.81,"min":9.72,"max":15.51,"night":9.72,"eve":15.51,"morn":10.35},"pressure":1016.65,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":2.35,"deg":353,"clouds":56,"rain":1.6},{"dt":1516219200,"temp":{"day":12.36,"min":8.36,"max":15.96,"night":9.96,"eve":15.96,"morn":8.36},"pressure":1014.43,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":1.23,"deg":46,"clouds":75}]}
         *
         */
        return Gson().fromJson(jsonStr, ForecastResult::class.java)
    }

}