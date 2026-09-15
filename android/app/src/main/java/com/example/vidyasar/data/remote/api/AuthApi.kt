package com.example.vidyasar.data.remote.api

import com.example.vidyasar.data.remote.model.LoginRequest
import com.example.vidyasar.data.remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {


    @POST("/api/auth/login")
    suspend fun login(
        @Body request : LoginRequest
    ): Response<LoginResponse>



}