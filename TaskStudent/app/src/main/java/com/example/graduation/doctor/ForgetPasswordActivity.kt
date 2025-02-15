package com.example.graduation.doctor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.databinding.ActivityForgetpasswordBinding

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetpasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)



        addcallback()
    }

    private fun addcallback() {
        binding.btnSendforgetPassToemail.setOnClickListener {
            val intent = Intent(this, CreatNewPasswordActvity::class.java)
            startActivity(intent)
        }
    }
}