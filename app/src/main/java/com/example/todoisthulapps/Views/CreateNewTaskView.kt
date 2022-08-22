package com.example.todoisthulapps.Views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todoisthulapps.Components.ButtonCreateTask
import com.example.todoisthulapps.Components.CustomOutlinedTextField
import com.example.todoisthulapps.Components.TitleText


@Composable
fun CreateNewTaskView() {
    Column(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())) {
        TitleText(title = "Create New Task")
        CustomOutlinedTextField(label = "Title", singleLineOn = true)
        CustomOutlinedTextField(label = "Description", singleLineOn = false)
        CustomOutlinedTextField(label = "Priority", singleLineOn = true)
        Column(
            modifier = Modifier
                .padding(100.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonCreateTask()
        }


    }
}

