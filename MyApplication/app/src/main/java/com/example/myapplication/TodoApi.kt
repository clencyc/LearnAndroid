package com.example.myapplication

import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TodoApi {

//    To tell retrofit what to retrieve from the API
    @GET("/todos")
    suspend fun getTodos(@Query("key") key: String): retrofit2.Response<List<Todo>>
}