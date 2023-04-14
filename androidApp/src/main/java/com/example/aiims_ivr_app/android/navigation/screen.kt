package com.example.aiims_ivr_app.android.navigation

sealed class screen(val route : String)
{
    object splash :screen(route = "splash")

    object signin : screen(route = "signin")

    object signup: screen(route = "signup")

    object way: screen(route = "way")

    object patientdata: screen(route = "patientdata")

    object callsetup: screen(route = "callsetup")

    object addnurse: screen(route = "addnurse")

    object audiosetup: screen(route = "audiosetup")
}
