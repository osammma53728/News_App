package com.example.graduation.doctor

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.graduation.call.ui.CallActivity
import com.example.graduation.R

class chat : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val video_Call: ImageView = findViewById(R.id.videoCall)
        val voice_Call: ImageView = findViewById(R.id.voiceCall)

        val send: ImageView = findViewById(R.id.send)
        val edit: EditText = findViewById(R.id.edit)

        val container_group3: FrameLayout = findViewById(R.id.container_group3)
        val container_group6: FrameLayout = findViewById(R.id.container_group6)

        send.setOnClickListener {
            if (edit.text.toString().equals("جاهز للسيشن ؟")) {
                container_group3.visibility = View.VISIBLE
            }
            if (edit.text.toString().equals("تمام جاهز")) {
                container_group6.visibility = View.VISIBLE
            }
        }

        video_Call.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            startActivity(intent)
        }
        voice_Call.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            startActivity(intent)
        }
    }
}