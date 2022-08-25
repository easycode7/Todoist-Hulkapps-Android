package com.example.todoisthulapps.ViewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.todoisthulapps.Components.TaskCard
import com.example.todoisthulapps.Model.Data.MockData.TaskItem
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.json.JSONArray
import java.lang.Exception
import kotlin.io.use

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

   TaskCard(task =  taskTitle.value,)
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


@Composable
fun downloadArray(context: Context, taskList: MutableList<String>) {
   val url = "https://todoist-hulkapps.herokuapp.com/epics/tasks"
   var queue = Volley.newRequestQueue(context)

   var request = JsonArrayRequest(Request.Method.GET, url, null, { response ->
      try {
          for (i in 0 until response.length()) {
             val responseObj = response.getJSONObject(i)
             var id = responseObj.getString("id")
             var title = responseObj.getString("title")
             var description = responseObj.getString("description")
             var priority = responseObj.getString("priority")
             taskList += title

          }
      } catch (e: Exception) {
         e.printStackTrace()
      }
   }, { error ->

   })
   queue.add(request)
}

// Post Method try382

object KtorClient {
   private val json = Json {
      encodeDefaults = true
      ignoreUnknownKeys = true
   }
   val httpClient = HttpClient {
      install(JsonFeature) {
         serializer = KotlinxSerializer(json)
      }
      install(Logging) {
         logger = object : Logger {
            override fun log(message: String) {
               Log.d("xapp-ktor", message)
            }
         }
         level = LogLevel.ALL
      }
      install(HttpTimeout) {
         socketTimeoutMillis = 15_0000
         requestTimeoutMillis = 15_000
         connectTimeoutMillis = 15_000
      }
      defaultRequest {
         contentType(ContentType.Application.Json)
         accept(ContentType.Application.Json)
      }
   }
}

suspend fun postData(): String {
   return KtorClient.httpClient.use {
      it.post("https://todoist-hulkapps.herokuapp.com/epics/tasks") {
         body =  Task("Test", "Description", "High")
      }
   }
}

@Serializable
data class Task(
   val title: String,
   val description: String,
   val priority: String
)


