package com.example.binlisttestcft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextNumber: EditText = findViewById(R.id.editTextNumber)
        val buttonEnter: Button = findViewById(R.id.buttonEnter)
        var binNumber: String = ""

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.binResponseLD.observe(this, Observer {
                bin -> val intent = DetailActivity.newIntent(this, bin, binNumber)
            startActivity(intent)
        })
        buttonEnter.setOnClickListener { it ->
            binNumber= editTextNumber.text.toString().trim()
            if (binNumber.length == 8 && binNumber.isDigitsOnly()){
                mainViewModel.getBinResponse(binNumber)
            } else {
                Toast.makeText(this@MainActivity,
                    getString(R.string.error), Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.menu_hisory, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuHistory) {
            val intent = HistoryActivity.newIntent(this)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}