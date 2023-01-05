package com.example.binlisttestcft

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface BinDAO {

    @Query("SELECT * FROM history_bin")
    fun getAllBinDB(): LiveData<List<Bin>>

    @Query("SELECT * FROM history_bin WHERE id == :idBin")
    fun getBinDB(idBin: Int): LiveData<Bin>

    @Insert
    fun insertBinDB(bin: Bin): Completable


}