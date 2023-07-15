package com.example.kmtest.data

data class User(
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)

data class UsersResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<User>
)
