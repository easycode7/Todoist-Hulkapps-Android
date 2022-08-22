package com.example.todoisthulapps.constants

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.todoisthulapps.R

object Constants {
   const val BASE_URL = "http://localhost:8080/epics/tasks"
   val Inter = FontFamily(
      Font(R.font.inter_regular),
      Font(R.font.inter_semibold, FontWeight.SemiBold)
   )
   val OpenSans = FontFamily(
      Font(R.font.opensans_semibold, FontWeight.SemiBold)
   )
}