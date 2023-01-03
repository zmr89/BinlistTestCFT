package com.example.binlisttestcft

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Number: Serializable {
    @SerializedName("length")
    var length: Int = 0

    @SerializedName("luhn")
    var luhn: Boolean = false


    override fun toString(): String {
        return "Number(length=$length, luhn=$luhn)"
    }

}