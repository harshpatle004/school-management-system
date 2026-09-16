package com.example.vidyasar.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vidyasar.data.remote.RetrofitClient
import com.example.vidyasar.data.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

    private val repository = LoginRepository(
        RetrofitClient.authApi
    )

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess = _loginSuccess.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    fun loin(
        schoolId: String,
        role: String,
        userId: String,
        password: String

    ) {
        viewModelScope.launch {
            try {
                val response = repository.login(
                    schoolId = schoolId,
                    role = role,
                    userId = userId,
                    password = password
                )

                if (response.isSuccessful){

                    val loginResponse = response.body()

                    if(loginResponse != null){
                        _loginSuccess.value = true
                    }
                    else{
                        _errorMessage.value = "Invalid server response"
                    }

                }else{
                    _errorMessage.value = "Invalid login credentials"
                }


            } catch (e : Exception) {
                _errorMessage.value = "Network error"

            }
        }


    }
}