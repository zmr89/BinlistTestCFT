package com.example.binlisttestcft

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.binlisttestcft.database.BinDatabase
import com.example.binlisttestcft.pojo.Bin
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val binDAO = BinDatabase.getInstance(application).getBinDAO()
    private val compositeDisposable = CompositeDisposable()

    companion object {
        private const val TAG = "DetailViewModel"
    }

    fun insertBinDB(bin: Bin) {
        val disposable = binDAO.insertBinDB(bin).subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(Action {
                Log.d(TAG, "insertBinDB() successful")
            }, {
                Log.d(TAG, it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}