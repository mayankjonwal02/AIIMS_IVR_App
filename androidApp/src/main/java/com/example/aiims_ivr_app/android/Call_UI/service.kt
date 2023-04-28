//package com.example.aiims_ivr_app.android.Call_UI
//
//import android.app.Service
//import android.content.Context
//import android.content.Intent
//import android.os.IBinder
//import android.telephony.PhoneStateListener
//import android.telephony.TelephonyManager
//import androidx.compose.ui.platform.LocalContext
//
//class PhoneStateService() : Service() {
//
//    private lateinit var phoneStateListener: OutgoingCallStateListener
//
//    override fun onBind(intent: Intent?): IBinder? {
//        return null
//    }
//
//
//    override fun onCreate() {
//        super.onCreate()
//        phoneStateListener = OutgoingCallStateListener(applicationContext)
//        val telephonyManager = applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        val telephonyManager = applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE)
//    }
//}
