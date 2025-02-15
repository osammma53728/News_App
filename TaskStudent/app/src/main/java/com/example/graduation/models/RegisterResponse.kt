package com.example.graduation.models

data class RegisterResponse(
    val msg: String, // registerd successfully
    val remember_token: String, //  OVQI89FX2P8V4Rx0BEmV99nGFQDY0
    val verification: Int // 1333
)