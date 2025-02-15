package com.example.graduation.doctor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addcallback()

    }


    private fun addcallback() {
        binding.welcomeNextBtn.setOnClickListener {
            val intent = Intent(this, BottomNavigationBarActivity::class.java)
            startActivity(intent)
        }
    }
}