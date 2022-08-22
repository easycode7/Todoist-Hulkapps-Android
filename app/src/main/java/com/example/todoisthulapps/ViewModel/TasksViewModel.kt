package com.example.todoisthulapps.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.todoisthulapps.Components.TaskCard
import java.lang.Exception

// ** Function to ParseJSON || Contains composable elements of TaskCards ** //

@Composable
fun ParseJSON() {
   val ctx = LocalContext.current

   val taskTitle = remember {
      mutableStateOf("")
   }
   val taskDescription = remember {
      mutableStateOf("")
   }
   val taskPriority = remember {
      mutableStateOf("")
   }

   jsonParsing(ctx, taskTitle, taskDescription, taskPriority)

   TaskCard(task =  taskTitle.value, priority = taskPriority.value)
}

// ** Function to decode JSON Object ** //

fun jsonParsing(
   ctx: Context,
   title: MutableState<String>,
   description: MutableState<String>,
   priority: MutableState<String>
) {
   var url =  "https://todoist-hulkapps.herokuapp.com/epics/tasks/1"
   var queue: RequestQueue = Volley.newRequestQueue(ctx)

   val request = JsonObjectRequest(Request.Method.GET, url, null,  { response ->

      try {
         val taskTitle: String = response.getString("title")
         val taskDescription: String = response.getString("description")
         val taskPriority: String = response.getString("priority")

         title.value = taskTitle
         description.value = taskDescription
         priority.value = taskPriority

      } catch (e: Exception) {
         e.printStackTrace()
      }

   }, { error ->
      Toast.makeText(ctx, "Still an error", Toast.LENGTH_SHORT)
         .show()
      error.printStackTrace()

   })
   queue.add(request)
}

