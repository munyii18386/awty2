package edu.washington.lmburu.awty

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.util.DateInterval
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_toast.*

private const val TAG = "main"

class MainActivity : AppCompatActivity() {
    private var alarmMgr: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent
//    private var message:Editable? = null
//    private  var phoneNumber:Editable? = null
//    private var alarmInterval:Editable? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      get the Alarm Manager
        alarmMgr = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        create pending intent
        alarmIntent = Intent(this, MyAlarm::class.java).let { intent ->
            PendingIntent.getBroadcast(this, 0, intent, 0)
        }
//      prevents the boot receiver from being called unnecessarily
        val receiver = ComponentName(this, MyAlarm::class.java)
        this.packageManager.setComponentEnabledSetting(
            receiver,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP)




//        tv_interval.addTextChangedListener(object: TextWatcher{
//            override fun afterTextChanged(s: Editable?) {  }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//        })

//
        val interval:Long = 2 * 1000
        val currentTime = System.currentTimeMillis()




        tv_btn.setOnClickListener {

//            on click intiate alarm
            alarmMgr?.setRepeating(AlarmManager.RTC_WAKEUP, currentTime+ interval, interval, alarmIntent)

            Toast.makeText(this, "intiated", Toast.LENGTH_SHORT).show()
            Log.i(TAG, "This alarm has been fired at: $currentTime")
            tv_btn.text = "STOP"
//            btn.isClickable = !(msg == "" || phone.isNullOrBlank() || minutes.isNullOrBlank())
        }

//        val toast = ToastFragment.newInstance()
//        val ft = supportFragmentManager.beginTransaction()
//        ft.replace(R.id.container, toast)
//        ft.addToBackStack(null)
//        ft.commit()

    }

    fun inputIsValid(){

    }


}

