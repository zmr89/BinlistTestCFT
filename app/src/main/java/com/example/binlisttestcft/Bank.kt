package com.example.binlisttestcft

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Bank: Serializable {
    @SerializedName("name")
    var bankName: String = ""

    @SerializedName("url")
    var url: String = ""

    @SerializedName("phone")
    var phone: String = ""


    override fun toString(): String {
        return "Bank(bankName='$bankName', url='$url', phone='$phone')"
    }

}