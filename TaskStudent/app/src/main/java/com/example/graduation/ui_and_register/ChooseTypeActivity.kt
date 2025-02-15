package com.example.graduation.ui_and_register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.R
import com.example.graduation.doctor.LoginActivity
import com.example.graduation.doctor.SignUpDoctorActivity

class ChooseTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosetype)

        val patientButton: Button = findViewById(R.id.user)
        val doctorButton: Button = findViewById(R.id.therapist)

        val action = intent.getStringExtra("action")

        patientButton.setOnClickListener {
            if (action == "register") {
                val intent = Intent(this, PatientRegister::class.java)
                startActivity(intent)
            } else if (action == "login") {
                val intent = Intent(this, LoginPage::class.java)
                startActivity(intent)
            }
        }

        doctorButton.setOnClickListener {
            // doctor code
            if (action == "register") {
                val intent = Intent(this, SignUpDoctorActivity::class.java)
                startActivity(intent)
            } else if (action == "login") {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
