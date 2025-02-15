package com.example.graduation.ui_and_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.graduation.R

class Patient_HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_home_)

        val reservation: AppCompatButton = findViewById(R.id.reservation)
        val profile: AppCompatButton = findViewById(R.id.Profile)
        val mydoctor: AppCompatButton = findViewById(R.id.my_doctor)
        val exercise: AppCompatButton = findViewById(R.id.exercise)
        val logout: AppCompatButton = findViewById(R.id.logout)
        val daily_mood: AppCompatButton = findViewById(R.id.daily_mood)

        reservation.setOnClickListener {
            val intent = Intent(this, Reservation::class.java)
            startActivity(intent)
        }
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        mydoctor.setOnClickListener {
            val intent = Intent(this, InfoDoctorActivity::class.java)
            startActivity(intent)
        }
        exercise.setOnClickListener {
            val intent = Intent(this, FirstExercise::class.java)
            startActivity(intent)
        }
        logout.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
        daily_mood.setOnClickListener {
            val intent = Intent(this, TrackMode::class.java)
            startActivity(intent)
        }
    }
}