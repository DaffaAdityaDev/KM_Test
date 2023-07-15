package com.example.kmtest.ThirdScreen

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kmtest.data.ReqresApi
import com.example.kmtest.data.User
import com.example.kmtest.data.UsersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ThirdScreenViewModel : ViewModel() {

    val usersData = MutableLiveData<List<User>>()

    fun getUsers() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ReqresApi::class.java)

        val call = api.getUsers(1, 10)
        call.enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                if (response.isSuccessful) {
                    val usersResponse = response.body()
                    val users = usersResponse?.data
                    // Update your adapter with the users
                    return usersData.postValue(users)
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                // Handle failure
                Toast.makeText(null, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }


}