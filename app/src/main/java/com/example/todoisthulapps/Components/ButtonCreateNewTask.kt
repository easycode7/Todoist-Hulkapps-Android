package com.example.todoisthulapps.Components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCreateTask() {
    Button(onClick = { /*TODO*/ },
    colors = ButtonDefaults.buttonColors(backgroundColor = Color(229, 49, 112)),
    shape = RoundedCornerShape(30.dp),
    modifier = Modifier.height(65.dp).width(150.dp)) {
        Text(text = "Create Task",
        color = Color.White)
    }
}