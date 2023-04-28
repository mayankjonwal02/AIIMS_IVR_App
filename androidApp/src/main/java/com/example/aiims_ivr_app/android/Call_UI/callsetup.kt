package com.example.aiims_ivr_app.android.Call_UI




import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
//import com.example.aiims_ivr_app.android.Manifest
import com.example.aiims_ivr_app.android.navigation.screen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import detectCallStatus


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun callsetup(navcontroller: NavHostController, context: Context) {
    var info by remember {
        mutableStateOf("")
    }
    var phonepermissionstate = rememberPermissionState(permission = android.Manifest.permission.READ_PHONE_STATE)
//
//
//
//    var call by remember {
//        mutableStateOf(false)
//    }
//
//
//    when {
//        phonepermissionstate.hasPermission ->
//        {
//                info = "permission already granted"
//            // Create an instance of TelephonyManager and register a PhoneStateListener
//            val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//            val phoneStateListener = OutgoingCallStateListener(context)
//            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
//
//        }
//        phonepermissionstate.shouldShowRationale ->
//        {
//                info = " permission denied"
//
//        }
//
//        else ->
//        {
//            LaunchedEffect(phonepermissionstate)
//            {
//                var result = phonepermissionstate.launchPermissionRequest()
//                val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//                val phoneStateListener = OutgoingCallStateListener(context)
//                telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
//
//                if(phonepermissionstate.hasPermission)
//                {
//                    info = "permission granted"
//                    // Create an instance of TelephonyManager and register a PhoneStateListener
//                    val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//                    val phoneStateListener = OutgoingCallStateListener(context)
//                    telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
//
//                }
//                else
//                {
//                    info =" fuck off"
//                     }
//            }
//        }
//    }
//


    var clicked by remember {
        mutableStateOf(false
        )
    }




    Box(modifier = Modifier.fillMaxSize())
    {

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(text = "Call Setup", modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(), style = TextStyle(textAlign = TextAlign.Center, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp, fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Normal),)
            Spacer(modifier = Modifier.height(90.dp))
            Card(modifier = Modifier
                .wrapContentSize()
                .shadow(10.dp, RoundedCornerShape(20.dp))
                .clickable {
                    clicked = !clicked


                }, backgroundColor = Color(0xFFFFC0CB)) {

                Text(text = "Start", style = TextStyle(fontSize = 50.sp), modifier = Modifier.padding(40.dp))

            }
            Text(text = info)
            Spacer(modifier = Modifier.height(50.dp))
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {

                OutlinedButton(modifier = Modifier.padding(20.dp), onClick = { navcontroller.navigate(screen.addnurse.route) }, colors = ButtonDefaults.outlinedButtonColors(), border = BorderStroke(1.dp,Color.Magenta)) {
                    Text(text = "Add Nurse", fontSize = 20.sp)

                }

                
            }

        }

    }

    if(clicked)
    {
        CallContact(context,phoneNumber = "9625401776")
    }

}

@Composable
fun CallContact(context: Context, phoneNumber: String) {


            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.READ_PHONE_STATE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
                context.registerReceiver(callreceiver(),callreceiver.filter)
                context.startActivity(intent)


            } else {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(Manifest.permission.CALL_PHONE,Manifest.permission.READ_PHONE_STATE),
                    1
                )
            }


        }

