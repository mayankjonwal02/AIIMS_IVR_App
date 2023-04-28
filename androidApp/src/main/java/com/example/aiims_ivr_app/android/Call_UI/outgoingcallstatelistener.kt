import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.telephony.TelephonyManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun detectCallStatus(onConnected: () -> Unit, onDeclined: () -> Unit) {
    val context = LocalContext.current
    val telephonyManager = remember { context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager }
    val callState = remember { mutableStateOf(TelephonyManager.CALL_STATE_IDLE) }

    val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
                val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
                callState.value = when (state) {
                    TelephonyManager.EXTRA_STATE_OFFHOOK -> TelephonyManager.CALL_STATE_OFFHOOK
                    TelephonyManager.EXTRA_STATE_IDLE -> TelephonyManager.CALL_STATE_IDLE
                    else -> callState.value
                }
                when (callState.value) {
                    TelephonyManager.CALL_STATE_OFFHOOK -> onConnected()
                    TelephonyManager.CALL_STATE_IDLE -> onDeclined()
                }
            }
        }
    }

    DisposableEffect(context) {
        context.registerReceiver(receiver, IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED))
        onDispose {
            context.unregisterReceiver(receiver)
        }
    }
}
