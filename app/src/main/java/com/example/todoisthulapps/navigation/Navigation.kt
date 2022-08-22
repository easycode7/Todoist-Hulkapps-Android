package com.example.todoisthulapps.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoisthulapps.Views.CreateNewTaskView
import com.example.todoisthulapps.Views.MainView


@Composable
fun Navigation() {

    val navController = rememberNavController()
    var text by remember {
        mutableStateOf("")
    }
    NavHost(navController = navController, startDestination = "main_view") {
        composable("main_view") {
            MainView(navController = navController)
        }
        composable("create_task_view") {
            CreateNewTaskView()
        }
    }

}