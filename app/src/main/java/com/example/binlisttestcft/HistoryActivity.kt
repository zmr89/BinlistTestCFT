package com.example.binlisttestcft

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
    }


}