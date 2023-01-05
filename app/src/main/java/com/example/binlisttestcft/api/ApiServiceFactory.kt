package com.example.binlisttestcft.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceFactory {

    private val baseUrl = "https://lookup.binlist.net/"

    fun getApiService(): ApiService {
        val retrofitInstance = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        val apiService = retrofitInstance.create(ApiService::class.java)
        return apiService
    }


}