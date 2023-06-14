package com.edgar.weatherapp.data.repository

import okhttp3.Call
import okhttp3.Callback
import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject

open class Repository {
    private val client = OkHttpClient()

    fun GET(url:String, method:String, headers:Headers, callback: Callback): Call {
        val request = Request.Builder()
            .url("$url$method")
            .headers(headers)
            .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

    fun POST(url:String, method:String, headers:Headers, jsonObject: JSONObject, callback: Callback): Call {
        val requestBody = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString())
        val request = Request.Builder()
            .url("$url$method")
            .headers(headers)
            .post(requestBody)
            .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }
}