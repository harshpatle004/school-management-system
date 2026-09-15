package com.example.vidyasar.data.remote.model

data class LoginRequest (
    val schoolId : String,
    val role : String,
    val userId : String,
    val password : String
)