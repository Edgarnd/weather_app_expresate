package com.edgar.weatherapp.data.response

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.core.*
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.node.*
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.module.kotlin.*

val mapper = jacksonObjectMapper().apply {
    propertyNamingStrategy = PropertyNamingStrategies.LOWER_CAMEL_CASE
    setSerializationInclusion(JsonInclude.Include.NON_NULL)
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
}

data class WeatherResponse (
    val data: Data? = null
) {
    fun toJson() = mapper.writeValueAsString(this)

    companion object {
        fun fromJson(json: String) = mapper.readValue<WeatherResponse>(json)
    }
}

data class Data (
    val timelines: List<Timeline>? = null
)

data class Timeline (
    val timestep: String? = null,
    val endTime: String? = null,
    val startTime: String? = null,
    val intervals: List<Interval>? = null
)

data class Interval (
    val startTime: String? = null,
    val values: Values? = null
)

data class Values (
    val temperature: Double? = null
)

