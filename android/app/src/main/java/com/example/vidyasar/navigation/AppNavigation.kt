package com.example.vidyasar.navigation

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost

@Composable
fun AppNavigation (navController: NavController) {
    NavHost  (navController = navController,)
}