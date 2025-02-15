package com.example.graduation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.ui_and_register.ChooseTypeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerButton: Button = findViewById(R.id.button1)
        val loginButton: Button = findViewById(R.id.button2)

        registerButton.setOnClickListener {
            val intent = Intent(this, ChooseTypeActivity::class.java)
            intent.putExtra("action", "register")
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val intent = Intent(this, ChooseTypeActivity::class.java)
            intent.putExtra("action", "login")
            startActivity(intent)
        }
    }
}