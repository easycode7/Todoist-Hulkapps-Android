package com.example.todoisthulapps.Components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.todoisthulapps.R

@Composable
fun AddButton(navController: NavController) {

    FloatingActionButton(onClick = { navController.navigate("create_task_view") },
        backgroundColor = Color(229, 49, 112)
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null,
            tint = Color.White,)
    }
}