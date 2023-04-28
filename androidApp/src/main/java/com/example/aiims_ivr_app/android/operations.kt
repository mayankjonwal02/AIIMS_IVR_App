package com.example.aiims_ivr_app.android

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.aiims_ivr_app.android.navigation.screen
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


suspend fun firebasesignin(
    email: String,
    password: String,
    context: Context,
    navcontroller: NavController,
    user: String?
)
{

    Firebase.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
        it -> if(it.isSuccessful)
    {
        if(user == "Organisation")
        { navcontroller.navigate(screen.callsetup.route) }
        else if (user == "Audio App")
        {
            navcontroller.navigate(screen.audiosetup.route)
        }
        Toast.makeText(context," Logined Successfully", Toast.LENGTH_LONG).show()

    }
        else
    {
        Toast.makeText(context," Error",Toast.LENGTH_LONG).show()
    }
    }
}


// color hunt