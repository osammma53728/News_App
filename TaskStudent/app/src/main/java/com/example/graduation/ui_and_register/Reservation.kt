package com.example.graduation.ui_and_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.graduation.R

class Reservation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_reservation)

        val moretextView: TextView = findViewById(R.id.text_more1)
        val booktextView: TextView = findViewById(R.id.text_book_now1)

        moretextView.setOnClickListener {
            val intent = Intent(this, MoreProfileDoctorActivity::class.java)
            startActivity(intent)
        }

        booktextView.setOnClickListener {
            val intent = Intent(this, AppointmentActivity::class.java)
            startActivity(intent)
        }

    }
}