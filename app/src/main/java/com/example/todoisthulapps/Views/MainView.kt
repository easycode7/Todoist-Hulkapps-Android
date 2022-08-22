package com.example.todoisthulapps.Views

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoisthulapps.Components.AddButton
import com.example.todoisthulapps.Components.TitleText
import com.example.todoisthulapps.ViewModel.ParseJSON

@Composable
fun MainView(navController: NavController) {
    Column {
        TitleText(title = "To Do List")
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column {
                ParseJSON()
            }
        }
        Row(horizontalArrangement =  Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
            Column(verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxHeight()) {
                AddButton(navController = navController)
            }
        }
    }
}

