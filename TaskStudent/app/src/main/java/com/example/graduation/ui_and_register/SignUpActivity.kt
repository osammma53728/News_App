package com.example.graduation.ui_and_register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var daySpinner: Spinner
    private lateinit var monthSpinner: Spinner
    private lateinit var yearSpinner: Spinner
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)

        nameEditText = findViewById(R.id.name_edittext)
        passwordEditText = findViewById(R.id.pass_edittext)
        daySpinner = findViewById(R.id.day_spinner)
        monthSpinner = findViewById(R.id.month_spinner)
        yearSpinner = findViewById(R.id.year_spinner)
        genderRadioGroup = findViewById(R.id.gender_radio_group)
        nextButton = findViewById(R.id.next)

        // Populate day spinner

        nextButton.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
    }


    }

}

