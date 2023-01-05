package com.example.binlisttestcft.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.binlisttestcft.pojo.Bin
import io.reactivex.rxjava3.core.Completable

@Dao
interface BinDAO {

    @Query("SELECT * FROM history_bin")
    fun getAllBinDB(): LiveData<List<Bin>>

    @Insert
    fun insertBinDB(bin: Bin): Completable
}