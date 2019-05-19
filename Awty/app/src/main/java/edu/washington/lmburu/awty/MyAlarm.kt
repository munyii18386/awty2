package edu.washington.lmburu.awty

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast


private const val TAG = "alarm"
class MyAlarm: BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {

        val givenMsg = intent?.getStringExtra("message")
        val givenPhoneNum = intent?.getStringExtra("phone")

        Toast.makeText(context, "$givenPhoneNum: Are We There Yet?", Toast.LENGTH_SHORT).show()


    }
}


