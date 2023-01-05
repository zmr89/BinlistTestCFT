package com.example.binlisttestcft

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.binlisttestcft.pojo.Bin
import com.example.binlisttestcft.pojo.BinResponse


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

        val textViewBINDetail: TextView = findViewById(R.id.textViewBINDetail)
        val textViewSchemeDetail: TextView = findViewById(R.id.textViewSchemeDetail)
        val textViewBrandDetail: TextView = findViewById(R.id.textViewBrandDetail)
        val textViewLengthDetail: TextView = findViewById(R.id.textViewLengthDetail)
        val textViewLuhnDetail: TextView = findViewById(R.id.textViewLuhnDetail)
        val textViewTypeDetail: TextView = findViewById(R.id.textViewTypeDetail)
        val textViewPrepaidDetail: TextView = findViewById(R.id.textViewPrepaidDetail)
        val textViewCountryNameDetail: TextView = findViewById(R.id.textViewCountryNameDetail)
        val textViewCountryCodeDetail: TextView = findViewById(R.id.textViewCountryCodeDetail)
        val textViewCountryCoordinatesDetail: TextView = findViewById(R.id.textViewCountryCoordinatesDetail)
        val textViewBankNameDetail: TextView = findViewById(R.id.textViewBankNameDetail)
        val textViewBankWebsiteDetail: TextView = findViewById(R.id.textViewBankWebsiteDetail)
        val textViewBankPhoneDetail: TextView = findViewById(R.id.textViewBankPhoneDetail)

        textViewBINDetail.text = "BIN: $binNumber"
        textViewSchemeDetail.text = "SCHEME/NETWORK: " + binResponse.scheme
        textViewBrandDetail.text = "BRAND: " + binResponse.brand
        textViewLengthDetail.text = "CARD NUMBER LENGTH: " + binResponse.number?.length.toString()
        textViewLuhnDetail.text = "CARD NUMBER LUHN: ${if (binResponse.number?.luhn == true) {" Yes "} else {" No "}}"
        textViewTypeDetail.text = "TYPE: " + binResponse.type
        textViewPrepaidDetail.text = "PREPAID:  ${if (binResponse.prepaid == true) {" Yes "} else {" No "}}"
        textViewCountryNameDetail.text = "COUNTRY NAME: " + binResponse.country?.countyName
        textViewCountryCodeDetail.text = "COUNTRY CODE: " + binResponse.country?.countryCode
        textViewCountryCoordinatesDetail.text = "COUNTRY COORDINATES: " +
            "latitude ${binResponse.country?.latitude}, longitude ${binResponse.country?.longitude}"
        textViewBankNameDetail.text = "BANK NAME: " + binResponse.bank?.bankName
        textViewBankWebsiteDetail.text = "BANK WEBSITE: " + binResponse.bank?.url
        textViewBankPhoneDetail.text = "BANK PHONE: " + binResponse.bank?.phone

        val detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.insertBinDB(Bin(binNumber = binNumber, binResponse = binResponse))

        textViewBankWebsiteDetail.setOnClickListener {
            val uriLink = Uri.parse("http://" + binResponse.bank?.url)
            val openLinkIntent = Intent(Intent.ACTION_VIEW, uriLink)
            if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(openLinkIntent)
            }
        }

        textViewBankPhoneDetail.setOnClickListener {
            val uriCall = Uri.parse("tel:" + binResponse.bank?.phone)
            val callIntent = Intent(Intent.ACTION_DIAL, uriCall)
            if (callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(callIntent)
            }
        }

        textViewCountryCoordinatesDetail.setOnClickListener {
            val uriMap = Uri.parse("geo:${binResponse.country?.latitude},${binResponse.country?.longitude}")
            val mapIntent = Intent(Intent.ACTION_VIEW, uriMap)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

    }







}