package com.example.vidyasar.data.remote.model

data class LoginResponse(
    val schoolId: String,
    val role: String,
    val loginId: String,
    val token: String
)