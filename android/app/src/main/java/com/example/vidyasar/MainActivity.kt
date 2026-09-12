package com.example.vidyasar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.vidyasar.navigation.AppNavigation
import com.example.vidyasar.ui.theme.VidyasarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VidyasarTheme {

                val navController = rememberNavController()
                AppNavigation(navController = navController)


            }
        }
    }
}

