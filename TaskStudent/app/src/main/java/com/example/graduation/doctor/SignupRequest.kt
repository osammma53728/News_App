package com.example.graduation.doctor

data class SignupRequest(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val idNumber: String,
    val photo: String
)