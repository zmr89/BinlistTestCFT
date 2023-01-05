package com.example.binlisttestcft

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.binlisttestcft.api.ApiServiceFactory
import com.example.binlisttestcft.pojo.BinResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val binResponseLD: MutableLiveData<BinResponse> = MutableLiveData<BinResponse>()
    val isErrorGetBinLD = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()

    fun getBinResponse(bin: String) {
        val disposable = ApiServiceFactory.getApiService().getBin(bin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { t -> binResponseLD.value = t },
                {
                    isErrorGetBinLD.value = true
                    Log.d("MainViewModel", it.message.toString())
                })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}