package com.example.binlisttestcft

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var binResponseLD: MutableLiveData<BinResponse> = MutableLiveData<BinResponse>()

    fun getBinResponse(bin: String) {
        ApiServiceFactory.getApiService().getBin(bin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { t -> binResponseLD.value = t })
    }

}