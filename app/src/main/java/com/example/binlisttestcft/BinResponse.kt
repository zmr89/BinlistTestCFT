package com.example.binlisttestcft

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class BinResponse: Serializable {
    @SerializedName("number")
    var number: Number? = null

    @SerializedName("scheme")
    var scheme: String = ""

    @SerializedName("type")
    var type: String = ""

    @SerializedName("brand")
    var brand: String = ""

    @SerializedName("prepaid")
    var prepaid: Boolean = false

    @SerializedName("country")
    var country: Country? = null

    @SerializedName("bank")
    var bank: Bank? = null


    override fun toString(): String {
        return "BinResponse(number=$number, scheme='$scheme', type='$type', brand='$brand', prepaid=$prepaid, country=$country, bank=$bank)"
    }

}