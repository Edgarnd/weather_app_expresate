package com.edgar.weatherapp.presentation.view

import com.edgar.weatherapp.data.response.CountriesResponse

interface ISearchView {
    fun busquedaClima(countriesResult: CountriesResponse?)
}