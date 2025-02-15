package com.example.graduation.doctor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.databinding.ActivityVerifyscanndataBinding

class VerifyScannDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerifyscanndataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyscanndataBinding.inflate(layoutInflater)
        setContentView(binding.root)


       addcallback()

    }

    private fun addcallback() {
         binding.btnFinish.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


}