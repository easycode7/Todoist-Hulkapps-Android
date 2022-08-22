package com.example.todoisthulapps.Components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomOutlinedTextField(label: String, singleLineOn: Boolean){
    var text by remember {
        mutableStateOf("")
    }
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.Center,  modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(value = text, onValueChange = { text = it}, label = {  Text(label) },
                singleLine = singleLineOn,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp))
        }
    }

}
