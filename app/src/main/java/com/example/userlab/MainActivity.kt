package com.example.userlab

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.userlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val birthYear = binding.etBirthYear.text.toString().toIntOrNull()
            val termsAccepted = binding.cbTerms.isChecked

            if (name.isBlank()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (birthYear == null || birthYear < 1900 || birthYear > 2024) {
                Toast.makeText(this, "Please enter a valid birth year", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!termsAccepted) {
                Toast.makeText(this, "You must accept the terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val currentYear = 2024
            val age = currentYear - birthYear

            val message = "Your name is $name, and since you were born in $birthYear, you are $age years old."

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("MESSAGE", message)
            }
            startActivity(intent)
        }
    }
}
