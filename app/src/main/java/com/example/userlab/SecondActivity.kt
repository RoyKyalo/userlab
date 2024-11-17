package com.example.userlab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.userlab.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("MESSAGE") ?: "No data received"
        binding.tvResult.text = message
    }
}
