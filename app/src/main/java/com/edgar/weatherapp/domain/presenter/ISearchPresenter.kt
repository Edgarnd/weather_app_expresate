package com.edgar.weatherapp.domain.presenter

import com.edgar.weatherapp.data.response.CountriesResponse

interface ISearchPresenter {
    fun buscarClima(searchValue: String)
}