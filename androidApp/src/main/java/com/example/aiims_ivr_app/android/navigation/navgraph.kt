package com.example.aiims_ivr_app.android.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aiims_ivr_app.android.AUDIO_UI.audiosetup
import com.example.aiims_ivr_app.android.Call_UI.callsetup
import com.example.aiims_ivr_app.android.NURSE.addnurse
import com.example.aiims_ivr_app.android.NURSE.patientdata
import com.example.aiims_ivr_app.android.SignIn
import com.example.aiims_ivr_app.android.SignUp
import com.example.aiims_ivr_app.android.signinas
import com.example.aiims_ivr_app.android.splashscreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun navgraph(navcontroller: NavHostController, context: Context) {

    NavHost(navController = navcontroller, startDestination = screen.splash.route)
    {
        composable(route = screen.splash.route)
        {
            splashscreen(navcontroller)
        }
        composable(route = "${screen.signin.route}/{user}")
        {
            var user = it.arguments?.getString("user")
            SignIn(navcontroller = navcontroller,user = user,context)
        }

        composable(route = "${screen.signup.route}/{user}")
        {
            var item = it.arguments?.getString("user")
            SignUp(navcontroller = navcontroller,user = item,context)
        }

        composable(route = screen.patientdata.route)
        {
            patientdata(navcontroller,context)
        }

        composable(route = screen.addnurse.route)
        {
            addnurse(navcontroller,context)
        }

        composable(route = screen.audiosetup.route)
        {
            audiosetup(navcontroller)
        }

        composable(route = screen.callsetup.route)
        {
            callsetup(navcontroller,context)
        }

        composable(route = screen.way.route)
        {
            signinas(navcontroller)
        }




    }

}