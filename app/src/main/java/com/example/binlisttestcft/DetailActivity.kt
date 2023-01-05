package com.example.binlisttestcft

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class DetailActivity : AppCompatActivity() {

    companion object{
        const val BINRESPONSE = "Bin"
        const val BIN_NUMBER = "bin_number"

        fun newIntent(context: Context, binResponse: BinResponse, binNumber: String) : Intent {
            val intent: Intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(BINRESPONSE, binResponse)
            intent.putExtra(BIN_NUMBER, binNumber)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val binResponse = intent.extras?.get(BINRESPONSE) as BinResponse
        val binNumber = intent.extras?.getString(BIN_NUMBER) as String

        var textViewBINDetail: TextView = findViewById(R.id.textViewBINDetail)
        var textViewSchemeDetail: TextView = findViewById(R.id.textViewSchemeDetail)
        var textViewBrandDetail: TextView = findViewById(R.id.textViewBrandDetail)
        var textViewLengthDetail: TextView = findViewById(R.id.textViewLengthDetail)
        var textViewLuhnDetail: TextView = findViewById(R.id.textViewLuhnDetail)
        var textViewTypeDetail: TextView = findViewById(R.id.textViewTypeDetail)
        var textViewPrepaidDetail: TextView = findViewById(R.id.textViewPrepaidDetail)
        var textViewCountryNameDetail: TextView = findViewById(R.id.textViewCountryNameDetail)
        var textViewCountryCodeDetail: TextView = findViewById(R.id.textViewCountryCodeDetail)
        var textViewCountryCoordinatesDetail: TextView = findViewById(R.id.textViewCountryCoordinatesDetail)
        var textViewBankNameDetail: TextView = findViewById(R.id.textViewBankNameDetail)
        var textViewBankWebsiteDetail: TextView = findViewById(R.id.textViewBankWebsiteDetail)
        var textViewBankPhoneDetail: TextView = findViewById(R.id.textViewBankPhoneDetail)

        textViewBINDetail.text = "BIN: $binNumber"
        textViewSchemeDetail.text = "SCHEME/NETWORK: " + binResponse.scheme
        textViewBrandDetail.text = "BRAND: " + binResponse.brand
        textViewLengthDetail.text = "CARD NUMBER LENGTH: " + binResponse.number?.length.toString()
        textViewLuhnDetail.text = "CARD NUMBER LUHN: ${if (binResponse.number?.luhn == true) {" Yes "} else {" No "}}"
        textViewTypeDetail.text = "TYPE: " + binResponse.type
        textViewPrepaidDetail.text = "PREPAID:  ${if (binResponse.prepaid == true) {" Yes "} else {" No "}}"
        textViewCountryNameDetail.text = "COUNTRY NAME: " + binResponse.country?.countyName
        textViewCountryCodeDetail.text = "COUNTRY CODE: " + binResponse.country?.countryCode
        textViewCountryCoordinatesDetail.text ="COUNTRY COORDINATES: " +
            "latitude ${binResponse.country?.latitude}, longitude ${binResponse.country?.longitude}"
        textViewBankNameDetail.text = "BANK NAME: " + binResponse.bank?.bankName
        textViewBankWebsiteDetail.text = "BANK WEBSITE: " + binResponse.bank?.url
        textViewBankPhoneDetail.text = "BANK PHONE: " + binResponse.bank?.phone

        val detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        detailViewModel.isSuccessInsertLD.observe(this, Observer {
//
//        })
        detailViewModel.insertBinDB(Bin(binNumber = binNumber, binResponse = binResponse))

    }







}