package com.example.graduation.doctor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.databinding.ActivityUsernameandpasswordBinding

class UsernameAndPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsernameandpasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsernameandpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)



        addcallback()
    }

    private fun addcallback() {
        binding.btnNextToSaveNamePassword.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}