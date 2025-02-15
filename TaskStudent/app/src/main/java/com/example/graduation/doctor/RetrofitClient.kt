package com.example.graduation.doctor

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://way2life.000webhostapp.com/api/"

    private val client = OkHttpClient.Builder()
        .connectTimeout(50, TimeUnit.SECONDS)
        .writeTimeout(150, TimeUnit.SECONDS)
        .readTimeout(50, TimeUnit.SECONDS)
        .callTimeout(50, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor(Interceptor { chain ->
            val originalRequest = chain.request()
            val originalUrl = originalRequest.url
            val url = originalUrl.newBuilder().build()
            val requestBuilder = originalRequest.newBuilder().url(url)
                .addHeader("Accept", "application/json")
            val request = requestBuilder.build()
            val response = chain.proceed(request)
            response.code//status code
            response
        })
        .build()
    private val gson = GsonBuilder().setLenient().create()

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        retrofit.create(ApiService::class.java)
    }
}