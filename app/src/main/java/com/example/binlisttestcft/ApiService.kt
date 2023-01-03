package com.example.binlisttestcft

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("{bin}")
    fun getBin(@Path("bin") bin: String): Single<BinResponse>

//    @GET("")
//    fun getBin(@Query("") bin: String): Single<BinResponse>
}