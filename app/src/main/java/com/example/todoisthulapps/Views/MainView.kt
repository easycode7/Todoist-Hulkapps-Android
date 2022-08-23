package com.example.todoisthulapps.Views

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.Group
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoisthulapps.Components.AddButton
import com.example.todoisthulapps.Components.TaskCard
import com.example.todoisthulapps.Components.TitleText
import com.example.todoisthulapps.ViewModel.downloadArray


@Composable
fun MainView(navController: NavController) {
    Column {
        TitleText(title = "To Do List")
       Box {
           Box {
               Row(modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.Center) {
                   Column {
                       displayArray()
                   }
               }
           }
           Box {
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
    }
}

@Composable
fun displayArray() {
    val context = LocalContext.current
    val taskTitle = remember {
        mutableStateOf("")
    }
    val taskList = remember { mutableStateListOf<String>() }
    val taskPriority = remember { mutableStateListOf<String>() }
    downloadArray(context = context, taskList = taskList )


    LazyColumn {
        // on below line we are populating
        // items for listview.
        items(taskList) { title ->

            TaskCard(task = title)

        }
    }
}
