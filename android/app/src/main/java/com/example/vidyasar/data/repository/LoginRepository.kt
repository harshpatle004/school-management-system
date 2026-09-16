package com.example.vidyasar.data.repository

import com.example.vidyasar.data.remote.api.AuthApi
import com.example.vidyasar.data.remote.model.LoginRequest
import com.example.vidyasar.data.remote.model.LoginResponse
import retrofit2.Response

class LoginRepository(
    private val authApi: AuthApi
) {

    suspend fun login(
        schoolId: String,
        role: String,
        userId: String,
        password: String
    ): Response<LoginResponse> {

        val request = LoginRequest(
            schoolId = schoolId,
            role = role,
            userId = userId,
            password = password
        )
        return authApi.login(request)
    }

}