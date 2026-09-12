package com.example.vidyasar.navigation


sealed class Screen(val route : String) {
    data object Login : Screen("login")


}