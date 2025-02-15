package com.example.graduation.doctor

import com.example.graduation.models.LoginResponse
import com.example.graduation.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
//    @POST("login")
//    fun login(@Body request: LoginRequest): Call<ApiResponse>


    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<LoginResponse>


    @FormUrlEncoded
    @POST("register")
      fun signup(
        @Field("name") fName: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("birth_date") birthday: String,
        @Field("gender") gender: String,
        @Field("phone") phone: String,
        @Field("last_name") last_name: String,
        @Field("status") status: String,
        @Field("type") type: String,
        ): Call<RegisterResponse>
}