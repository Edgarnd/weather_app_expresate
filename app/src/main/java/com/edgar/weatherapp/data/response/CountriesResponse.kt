package com.edgar.weatherapp.data.response

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.core.*
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.node.*
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.module.kotlin.*

class CountriesResponse(elements: Collection<CountriesResponseElement>) : ArrayList<CountriesResponseElement>(elements) {
    fun toJson() = mapper.writeValueAsString(this)

    companion object {
        fun fromJson(json: String) = mapper.readValue<CountriesResponse>(json)
    }
}

data class CountriesResponseElement (
    val name: Name? = null,
    val latlng: List<Double>? = null,
)

data class CapitalInfo (
    val latlng: List<Double>? = null
)

data class Car (
    val signs: List<String>? = null,
    val side: String? = null
)

data class CoatOfArms (
    val png: String? = null,
    val svg: String? = null
)

data class Currencies (
    @get:JsonProperty("GTQ")@field:JsonProperty("GTQ")
    val gtq: Gtq? = null
)

data class Gtq (
    val name: String? = null,
    val symbol: String? = null
)

data class Demonyms (
    val eng: Eng? = null,
    val fra: Eng? = null
)

data class Eng (
    val f: String? = null,
    val m: String? = null
)

data class Flags (
    val png: String? = null,
    val svg: String? = null,
    val alt: String? = null
)

data class Gini (
    @get:JsonProperty("2014")@field:JsonProperty("2014")
    val the2014: Double? = null
)

data class Idd (
    val root: String? = null,
    val suffixes: List<String>? = null
)

data class Languages (
    val spa: String? = null
)

data class Maps (
    val googleMaps: String? = null,
    val openStreetMaps: String? = null
)

data class Name (
    val common: String? = null,
    val official: String? = null,
    val nativeName: NativeName? = null
)

data class NativeName (
    val spa: Translation? = null
)

data class Translation (
    val official: String? = null,
    val common: String? = null
)

data class PostalCode (
    val format: String? = null,
    val regex: String? = null
)
