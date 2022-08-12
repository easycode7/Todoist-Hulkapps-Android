package com.example.todoisthulapps.ViewModel

import com.example.todoisthulapps.Model.Data.MockData.TaskItem
import com.example.todoisthulapps.constants.Constants
import retrofit.http.GET

interface TasksViewModel {
   @GET(Constants.BASE_URL)
   suspend fun FetchTasks():  ArrayList<TaskItem>
}