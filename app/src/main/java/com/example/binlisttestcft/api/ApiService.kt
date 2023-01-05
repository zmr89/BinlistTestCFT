package com.example.binlisttestcft.api

import com.example.binlisttestcft.pojo.BinResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{bin}")
    fun getBin(@Path("bin") bin: String): Single<BinResponse>
}