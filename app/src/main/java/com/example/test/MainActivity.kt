package com.example.test

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "FirstActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        btnIntentExplicit.setOnClickListener{
           createIntentExplicit()
        }
        btnIntentImplicit.setOnClickListener{
            createIntentImplicit()
        }
        btnIntentAction.setOnClickListener{
            sendDataByAction()
        }
    }
    private fun sendDataByAction(){
        val intent2 = Intent(Intent.ACTION_SEND)
        intent2.type = "text/plain"
        intent2.putExtra(Intent.EXTRA_TEXT, "Hello các bạn")
        startActivity(intent2)
    }
    private fun createIntentImplicit(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
        startActivity(intent)
    }

    private fun createIntentExplicit(){
        //Intent explicit and send data by putExtra
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("keyString", "Nguyễn Ngọc Hà Giang")
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            startActivityForResult(
                    Intent(Intent.ACTION_PICK, Uri.parse("content://contacts")),
                    PICK_CONTACT_REQUEST)
            return true
        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        when (requestCode) {
            PICK_CONTACT_REQUEST ->
                if (resultCode == RESULT_OK) {
                    startActivity(Intent(Intent.ACTION_VIEW, intent?.data))
                }
        }
    }

    companion object {
        internal const val PICK_CONTACT_REQUEST = 0
    }
}