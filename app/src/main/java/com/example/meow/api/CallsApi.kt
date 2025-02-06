package com.example.meow.api

import com.example.meow.NewsResponse
import com.example.meow.util.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CallsApi {
    @GET("v2/top-headlines")
   suspend fun getHeadlines(
        @Query("country")
        country: String="us",
        @Query("page")
        pageNumber: Int=1,
        @Query("apiKey")
        apiKey: String= Constants.API_KEY
    ): Response<NewsResponse>

     @GET("v2/everything")
   suspend fun searchForNews(
       @Query("q")
       searchQuery: String,
       @Query("page")
       pageNumber: Int=1,
       @Query("apiKey")
       apiKey: String= Constants.API_KEY
   ): Response<NewsResponse>


}