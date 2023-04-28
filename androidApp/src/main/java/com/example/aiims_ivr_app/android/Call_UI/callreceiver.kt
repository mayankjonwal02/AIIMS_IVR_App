package com.example.aiims_ivr_app.android.Call_UI

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.telephony.TelephonyManager
import android.view.Gravity
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

public class callreceiver : BroadcastReceiver() {
    companion object {
        val filter = IntentFilter().apply {
            addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null) {
            if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
            {
                var toast = Toast.makeText(context," call started",Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()

            }
            else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE))
            {
                var toast = Toast.makeText(context," call ended",Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }
    }
}