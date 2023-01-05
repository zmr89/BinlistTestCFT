package com.example.binlisttestcft

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class HistoryActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context) : Intent {
            val intent: Intent = Intent(context, HistoryActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val historyViewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)
        historyViewModel.getAllBinDB().observe(this, Observer {
            Log.d("HistoryActivity", it.toString())
        })

    }


}