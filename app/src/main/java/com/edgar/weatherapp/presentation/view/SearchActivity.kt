package com.edgar.weatherapp.presentation.view

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.widget.addTextChangedListener
import com.edgar.weatherapp.R
import com.edgar.weatherapp.data.response.CountriesResponse
import com.edgar.weatherapp.databinding.ActivitySearchBinding
import com.edgar.weatherapp.domain.presenter.ISearchPresenter
import com.edgar.weatherapp.domain.presenter.SearchPresenter

class SearchActivity : AppCompatActivity(), ISearchView {
    private val presenter by lazy { SearchPresenter(this) }
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_app_bar)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTxtCountry.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //NOT implemented yet
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.buscarClima(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {
                //NOT implemented yet
            }
        })
    }

    override fun busquedaClima(countriesResult: CountriesResponse?) {
        if(countriesResult != null){
            Log.d("SearchActivity", countriesResult.toJson())
            runOnUiThread {
                binding.llResultCountries.removeAllViews()
                for (country in countriesResult){
                    val llContainerParams = LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    val llContainer = LinearLayout(this)
                    llContainer.layoutParams = llContainerParams
                    llContainer.orientation = LinearLayout.VERTICAL
                    llContainer.setPadding(0, 20, 0, 20)

                    val txtViewCountryName = TextView(this)
                    txtViewCountryName.text = country.name?.common
                    txtViewCountryName.textSize = 18f

                    val txtViewAction = TextView(this)
                    txtViewAction.text = getString(R.string.see_weather)

                    llContainer.dividerDrawable = getDrawable(android.R.drawable.divider_horizontal_bright)
                    llContainer.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE

                    llContainer.addView(txtViewCountryName)
                    llContainer.addView(txtViewAction)

                    llContainer.setOnClickListener {

                    }

                    binding.llResultCountries.addView(llContainer)
                }
            }
        }
    }
}