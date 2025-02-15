package com.example.graduation.ui_and_register

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.graduation.R
import com.example.graduation.doctor.infoandnotes

class TrackMode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_mode)

        val addnote: TextView = findViewById(R.id.text_add_note)

        addnote.setOnClickListener {
            val intent = Intent(this, infoandnotes::class.java)
            startActivity(intent)
        }

    }
}