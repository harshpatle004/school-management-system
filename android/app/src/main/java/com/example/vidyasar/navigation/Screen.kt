package com.example.vidyasar.navigation

sealed class Screen(val route: String) {

    data object Login : Screen("login")

    data object StudentDashboard : Screen("student_dashboard")

    data object TeacherDashboard : Screen("teacher_dashboard")

    data object AdminDashboard : Screen("admin_dashboard")
}