package com.example.todoisthulapps.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoisthulapps.constants.Constants.Inter

@Composable
fun TitleText(title : String) {
    Text(text = title,
        modifier = Modifier
            .padding(top = 40.dp)
            .padding(bottom = 20.dp)
            .padding(start = 15.dp),
        fontSize = 25.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold
    )
}