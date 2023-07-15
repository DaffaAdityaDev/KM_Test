package com.example.kmtest.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresApi {
    @GET("users")
    fun getUsers(@Query("page") page: Int, @Query("per_page") perPage: Int): Call<UsersResponse>
}
