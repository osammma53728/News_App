package com.example.graduation.ui_and_register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.R

class LoginPage : AppCompatActivity() {
    private lateinit var emailOrPhoneEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var forgetPasswordTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        emailOrPhoneEditText = findViewById(R.id.phone_editText)
        passwordEditText = findViewById(R.id.pass_edittext)
        loginButton = findViewById(R.id.login)
        forgetPasswordTextView = findViewById(R.id.forget_pass)

        loginButton.setOnClickListener {
            val intent = Intent(this, Patient_HomeActivity::class.java)
            startActivity(intent)

        }


        forgetPasswordTextView.setOnClickListener {
            val intent = Intent(this, ForgetPassActivity::class.java)
            startActivity(intent)
        }

    }

    }



