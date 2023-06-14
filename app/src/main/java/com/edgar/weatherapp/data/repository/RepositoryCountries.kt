package com.edgar.weatherapp.data.repository

import android.util.Log
import com.edgar.weatherapp.data.response.CountriesResponse
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import java.lang.Exception

class RepositoryCountries {
    private val TAG = "RepositoryCountries"
    private val repositoryDefault = RepositoryDefault()

    fun getCountriesByName(searchValue: String, then: ((CountriesResponse?) -> Unit)) {
        repositoryDefault.getMethod("https://restcountries.com", "/v3.1/name/$searchValue",
            object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    then(null)
                }
                override fun onResponse(call: Call, response: Response) {
                    try {
                        val responseBodyStr = response.body()?.string().toString()
                        val responseBody = CountriesResponse.fromJson(responseBodyStr)
                        then(responseBody)
                    } catch (e:Exception){
                        Log.d(TAG, e.toString())
                    }
                }
            }
        )
    }
}