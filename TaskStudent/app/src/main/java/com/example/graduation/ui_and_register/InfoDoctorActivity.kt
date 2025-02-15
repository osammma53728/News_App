package com.example.graduation.ui_and_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.graduation.R
import com.example.graduation.doctor.chat

class InfoDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_doctor_info)

        val textchat: TextView = findViewById(R.id.text_chat)

        textchat.setOnClickListener {
            val intent = Intent(this, chat::class.java)
            startActivity(intent)
        }

    }
}