package com.example.binlisttestcft.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.binlisttestcft.pojo.Bin

@Database(entities = [Bin::class], version = 1, exportSchema = false)
abstract class BinDatabase : RoomDatabase() {


    companion object{
        private const val DB_NAME = "bin.db"
        private var db: BinDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): BinDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(context, BinDatabase::class.java, DB_NAME).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun getBinDAO(): BinDAO


}