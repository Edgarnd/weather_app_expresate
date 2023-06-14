package com.edgar.weatherapp.data.repository

import android.util.Log
import okhttp3.Callback
import okhttp3.Headers
import org.json.JSONObject

class RepositoryDefault() : Repository() {
    private val TAG = "RepositoryDefault"

    fun getMethod(url: String, method: String, callback: Callback){
        val headerBuilder = Headers.Builder().add("Content-Type", "application/json; charset=utf-8")
        Log.d(TAG, "REQUEST GET URL $url$method")
        GET(url, method, headerBuilder.build(), callback)
    }
    fun postMethod(url: String, method: String, json: JSONObject, callback: Callback){
        val headerBuilder = Headers.Builder().add("Content-Type", "application/json; charset=utf-8")
        Log.d(TAG, "REQUEST POST URL $url$method")
        POST(url, method, headerBuilder.build(), json, callback)
    }
}