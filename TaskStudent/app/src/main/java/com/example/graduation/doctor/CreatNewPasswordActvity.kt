package com.example.graduation.doctor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.databinding.ActivityCreatnewpasswordBinding

class CreatNewPasswordActvity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatnewpasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatnewpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addcallback()

    }

    private fun addcallback() {
        binding.btnSendtoConfirmNewPass.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}