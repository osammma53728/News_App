package com.example.graduation.ui_and_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.example.graduation.R

class SecondExercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_exercise)

        val back: ImageView = findViewById(R.id.back)
        val forward: ImageView = findViewById(R.id.forward)

        back.setOnClickListener {
            val intent = Intent(this, FirstExercise::class.java)
            startActivity(intent)
        }
        forward.setOnClickListener {
            val intent = Intent(this, ThirdExercise::class.java)
            startActivity(intent)
        }

    }
}