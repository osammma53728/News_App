package com.example.graduation

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("verify/email")
    fun verifyEmail(@Body request: VerifyRequest): Call<VerifyResponse>

    @POST("verify/phone")
    fun verifyPhone(@Body request: VerifyRequest): Call<VerifyResponse>

    @POST("register")
    fun registerUser(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("login")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

    @POST("forgot-password")
    fun forgotPassword(@Body request: ForgotPasswordRequest): Call<ForgotPasswordResponse>

    @POST("reset-password")
    fun resetPassword(@Body request: ResetPasswordRequest): Call<ResetPasswordResponse>
}

data class RegisterRequest(
    val name: String,
    val password: String,
    val birthdate: String,
    val gender: String
)

data class RegisterResponse(
    val success: Boolean,
    val message: String
)

data class VerifyRequest(
    val code: String
)


data class VerifyResponse(
    val success: Boolean,
    val message: String
)

data class LoginRequest(
    val emailOrPhone: String,
    val password: String
)

data class LoginResponse(
    val success: Boolean,
    val message: String
)


data class ForgotPasswordRequest(
    val email: String
)

data class ForgotPasswordResponse(
    val success: Boolean,
    val message: String
)

data class ResetPasswordRequest(
    val email: String,
    val newPassword: String
)

data class ResetPasswordResponse(
    val success: Boolean,
    val message: String
)


