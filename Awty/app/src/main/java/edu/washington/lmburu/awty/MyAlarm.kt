package edu.washington.lmburu.awty

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_toast.*

private const val TAG = "alarm"
class MyAlarm: BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(context, "fired", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "awty")


    }
}


