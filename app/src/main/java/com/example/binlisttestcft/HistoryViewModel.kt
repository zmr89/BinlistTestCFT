package com.example.binlisttestcft

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val binDAO = BinDatabase.getInstance(application).getBinDAO()

    fun getAllBinDB(): LiveData<List<Bin>> {
        return binDAO.getAllBinDB()
    }
}