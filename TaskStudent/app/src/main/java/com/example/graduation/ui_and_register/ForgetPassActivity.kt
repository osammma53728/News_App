package com.example.graduation.ui_and_register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.R

class ForgetPassActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var backArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forget_pass)

        emailEditText = findViewById(R.id.pass_edittext)
        sendButton = findViewById(R.id.send)
        backArrow = findViewById(R.id.back_arrow)

        sendButton.setOnClickListener {
            val intent = Intent(this, CreateNewPassActivity::class.java)
            startActivity(intent)
        }

    }

}

