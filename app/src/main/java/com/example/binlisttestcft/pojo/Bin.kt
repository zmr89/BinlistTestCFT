package com.example.binlisttestcft.pojo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_bin")
data class Bin (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val binNumber: String? = null,

    @Embedded
    var binResponse: BinResponse? = null
)