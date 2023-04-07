package com.example.aiims_ivr_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform