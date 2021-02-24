package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {
    private val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getDataFromIntent()
    }
    private fun getDataFromIntent(){
        val intent1 = intent
        val key = intent1.getStringExtra("keyString")
        if (key != null) {
            Log.d(TAG, key)
        }
    }

}