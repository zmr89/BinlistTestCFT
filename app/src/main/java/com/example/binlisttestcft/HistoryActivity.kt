package com.example.binlisttestcft

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.binlisttestcft.adapters.HistoryAdapter
import com.example.binlisttestcft.pojo.Bin
import com.example.binlisttestcft.pojo.BinResponse

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
            val recyclerView: RecyclerView = findViewById(R.id.recyclerViewHistory)
            val historyAdapter = HistoryAdapter()
            historyAdapter.listBins = it
            recyclerView.adapter = historyAdapter


            historyAdapter.onClickBinListener = object : HistoryAdapter.OnClickBinListener{
                override fun onClickBin(bin: Bin) {
                    val binResponse = bin.binResponse as BinResponse
                    val binNumber = bin.binNumber as String
                    val intent = DetailActivity.newIntent(this@HistoryActivity, binResponse, binNumber)
                    startActivity(intent)
                }

            }
        })

    }


}