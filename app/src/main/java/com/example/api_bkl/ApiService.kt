package com.example.api_bkl

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("sources/?apiKey=e0ukp9nF8P1LbZdvLpisAJ1HMaa5nYXqovxcf67P")
    suspend fun getMovieSources(): List<moviejson>
}

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.watchmode.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
