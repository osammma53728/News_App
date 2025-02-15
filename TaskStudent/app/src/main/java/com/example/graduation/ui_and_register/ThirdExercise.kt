package com.example.graduation.ui_and_register

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.example.graduation.R

class ThirdExercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_exercise)

        val back: ImageView = findViewById(R.id.back)

        back.setOnClickListener {
            val intent = Intent(this, SecondExercise::class.java)
            startActivity(intent)
        }

    }
}