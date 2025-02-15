package com.example.graduation.ui_and_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.graduation.R

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_questions)

        val reservation: TextView = findViewById(R.id.container_group2)

        reservation.setOnClickListener {
            val intent = Intent(this, InfoDoctorActivity::class.java)
            startActivity(intent)
        }

    }
}