package com.edgar.weatherapp.data.repository

import com.edgar.weatherapp.data.response.WeatherResponse
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class RepositoryWeather {
    private val repositoryDefault = RepositoryDefault()

    fun getWeatherTimeline(lat: Double, lon: Double, then: ((WeatherResponse) -> Unit)) {
        val fields = "temperature"
        val timesteps = "1h"
        val units = "metric"
        val apikey = "qN8KyxsJvDPt2VZJU5JvytmQF6E8zD4n"

        val methodParams = """/v4/timelines?location=$lat,$lon&fields=$fields&timesteps=$timesteps&units=$units
            |               &apikey=$apikey"""
        repositoryDefault.getMethod("https://api.tomorrow.io", methodParams, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                //Not yet implemented
            }

            override fun onResponse(call: Call, response: Response) {
                //Not yet implemented
            }
        })
    }
}