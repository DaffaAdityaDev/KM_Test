package com.example.kmtest.ThirdScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kmtest.R
import com.example.kmtest.data.User
import com.example.kmtest.databinding.ActivityThirdScreenBinding

class ThirdScreen : AppCompatActivity() {

    lateinit var binding: ActivityThirdScreenBinding
    lateinit var viewModel: ThirdScreenViewModel
    lateinit var adapter: ThirdScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ThirdScreenAdapter(listOf())

        binding.rvThirdScreen.adapter = adapter
        binding.rvThirdScreen.layoutManager = LinearLayoutManager(this)

        viewModel = ThirdScreenViewModel()
        viewModel.getUsers()

        viewModel.usersData.observe(this) {
            // Update your adapter with the users
            adapter.updateUsers(it)
        }

        binding.ibTsBack.setOnClickListener {
            finish()
        }

    }
}