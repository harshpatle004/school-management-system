package com.example.vidyasar.login

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController

@Composable
fun LoginScreen (
    navController: NavController
){

    val schoolId by remember {
        mutableStateOf("")
    }

    val role by remember {
        mutableStateOf("")
    }

    val loginId by remember {
        mutableStateOf("")
    }
    val password by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = schoolId,
        label = ""

    )

}