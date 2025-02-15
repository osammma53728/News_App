package com.example.graduation.ui_and_register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.R

class CreateNewPassActivity : AppCompatActivity() {

    private lateinit var newPasswordEditText: EditText
    private lateinit var confirmNewPasswordEditText: EditText
    private lateinit var sendNewButton: Button
    private lateinit var backArrow: ImageView
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_new_pass)

        newPasswordEditText = findViewById(R.id.new_pass)
        confirmNewPasswordEditText = findViewById(R.id.confirm_new_pass)
        sendNewButton = findViewById(R.id.send_new)
        backArrow = findViewById(R.id.back_arrow)
        email = intent.getStringExtra("email") ?: ""

        sendNewButton.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }


    }
}

