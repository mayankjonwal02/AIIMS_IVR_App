//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.content.IntentFilter
//import android.telephony.PhoneStateListener
//import android.telephony.TelephonyManager
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.DisposableEffect
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.platform.LocalContext
//
//class CallStateReceiver : BroadcastReceiver() {
//
//    lateinit var phoneStateListener: PhoneStateListener
//
//    override fun onReceive(context: Context?, intent: Intent?) {
//        context ?: return
//        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//        phoneStateListener = object : PhoneStateListener() {
//            override fun onCallStateChanged(state: Int, phoneNumber: String?) {
//                super.onCallStateChanged(state, phoneNumber)
//                when (state) {
//                    TelephonyManager.CALL_STATE_IDLE -> {
//                        isRinging.value = false
//                        isOffhook.value = false
//                        isDisconnected.value = true
//                    }
//                    TelephonyManager.CALL_STATE_RINGING -> {
//                        isRinging.value = true
//                        isOffhook.value = false
//                        isDisconnected.value = false
//                    }
//                    TelephonyManager.CALL_STATE_OFFHOOK -> {
//                        isRinging.value = false
//                        isOffhook.value = true
//                        isDisconnected.value = false
//                    }
//                }
//            }
//        }
//        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
//    }
//
//    companion object {
//        val isRinging = mutableStateOf(false)
//        val isOffhook = mutableStateOf(false)
//        val isDisconnected = mutableStateOf(false)
//    }
//}
//
//@Composable
//fun CallState() {
//    val context = LocalContext.current
//    val receiver = remember { CallStateReceiver() }
//
//    DisposableEffect(context) {
//        val intentFilter = IntentFilter()
//        intentFilter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED)
//        context.registerReceiver(receiver, intentFilter)
//
//        onDispose {
//            context.unregisterReceiver(receiver)
//            receiver.phoneStateListener.let { listener ->
//                val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//                telephonyManager.listen(listener, PhoneStateListener.LISTEN_NONE)
//            }
//        }
//    }
//
//    // Render UI based on call state
//    if (receiver.isRinging.value) {
//        // Incoming call
//    } else if (receiver.isOffhook.value) {
//        // Outgoing or connected call
//    } else if (receiver.isDisconnected.value) {
//        // Disconnected call
//    }
//}
