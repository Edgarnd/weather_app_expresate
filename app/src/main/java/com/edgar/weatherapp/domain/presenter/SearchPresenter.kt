package com.edgar.weatherapp.domain.presenter

import com.edgar.weatherapp.data.repository.RepositoryCountries
import com.edgar.weatherapp.data.response.CountriesResponse
import com.edgar.weatherapp.presentation.view.ISearchView

class SearchPresenter(var view:ISearchView): ISearchPresenter {
    private val repositoryCountries = RepositoryCountries()

    override fun buscarClima(searchValue: String) {
        repositoryCountries.getCountriesByName(searchValue){ res ->
            view.busquedaClima(res)
        }
    }
}