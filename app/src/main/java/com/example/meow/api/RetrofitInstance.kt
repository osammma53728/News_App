package com.example.meow.api

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        val logging=HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client=okhttp3.OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder().baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    val api by lazy {
        retrofit.create(CallsApi::class.java)

    }
}