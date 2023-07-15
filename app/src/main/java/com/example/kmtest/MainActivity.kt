package com.example.kmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kmtest.databinding.ActivityMainBinding
import com.example.kmtest.utils.EXTRA.Companion.EXTRA_NAME

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFsNext.setOnClickListener {
            val intent = Intent(this, SecondScreen::class.java)
            intent.putExtra(EXTRA_NAME, binding.etFsName.text.toString())
            startActivity(intent)
        }

        binding.btnFsCheckPalindrome.setOnClickListener {
            val sentence = binding.etFsPalindrome.text.toString()
            val isPalindrome = checkPalindrome(sentence)

            val message = if (isPalindrome) {
                "The sentence is a palindrome"
            } else {
                "The sentence is not a palindrome"
            }

            AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }


    }

    private fun checkPalindrome(sentence: String): Boolean {
        val sentenceWithoutSpaces = sentence.replace("""[\W+]""".toRegex(), "")
        val sentenceReversed = sentenceWithoutSpaces.reversed()

        return sentenceWithoutSpaces.equals(sentenceReversed, ignoreCase = true)
    }
}