package com.example.binlisttestcft

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Country: Serializable {
    @SerializedName("numeric")
    var numeric: String = ""

    @SerializedName("alpha2")
    var alpha2: String = ""

    @SerializedName("name")
    var countyName: String = ""

    @SerializedName("emoji")
    var countryCode: String = ""

    @SerializedName("currency")
    var currency: String = ""

    @SerializedName("latitude")
    var latitude: String = ""

    @SerializedName("longitude")
    var longitude: String = ""


    override fun toString(): String {
        return "Country(numeric='$numeric', alpha2='$alpha2', countyName='$countyName', countryCode='$countryCode', currency='$currency', latitude='$latitude', longitude='$longitude')"
    }

}