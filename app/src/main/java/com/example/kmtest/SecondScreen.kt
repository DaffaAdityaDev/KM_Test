package com.example.kmtest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kmtest.ThirdScreen.ThirdScreen
import com.example.kmtest.databinding.ActivitySecondScreenBinding

class SecondScreen : AppCompatActivity() {

    lateinit var binding: ActivitySecondScreenBinding

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val name = data?.getStringExtra("EXTRA_USERNAME")
            // use the name
            binding.tvSsSelectUsername.text = name
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("EXTRA_NAME")

        if (name.isNullOrEmpty()) {
            binding.tvSsUsername.text = "John Doe"
        } else {
            binding.tvSsUsername.text = name
        }

        binding.btnSsChoseAUser.setOnClickListener {
            val intent = Intent(this, ThirdScreen::class.java)
            startForResult.launch(intent)
        }

        binding.ibSsBack.setOnClickListener {
            finish()
        }

    }
}