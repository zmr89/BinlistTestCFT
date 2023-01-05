package com.example.binlisttestcft

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.binlisttestcft.database.BinDatabase
import com.example.binlisttestcft.pojo.Bin

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val binDAO = BinDatabase.getInstance(application).getBinDAO()

    fun getAllBinDB(): LiveData<List<Bin>> {
        return binDAO.getAllBinDB()
    }
}