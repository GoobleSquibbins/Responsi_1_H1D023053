package com.example.responsi1mobileh1d023053

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.football-data.org/v4/"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("X-Auth-Token", "2c44b20c477c40f3b38f5b733fbcc1d7")
                .build()
            chain.proceed(newRequest)
        }
        .build()

    val instance: FootballApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballApiService::class.java)
    }
}
