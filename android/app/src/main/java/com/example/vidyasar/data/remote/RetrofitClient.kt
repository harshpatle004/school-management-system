package com.example.vidyasar.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL =
        "https://school-management-system-39h4.onrender.com/"

    val authApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(com.example.vidyasar.data.remote.api.AuthApi::class.java)
}