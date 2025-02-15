package com.example.graduation.call.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codewithkael.firebasevideocall.repository.MainRepository
import com.example.graduation.databinding.ActivityLoginBinding
import com.example.graduation.databinding.ActivityLoginCallBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var  views: ActivityLoginCallBinding
    @Inject lateinit var mainRepository: MainRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityLoginCallBinding.inflate(layoutInflater)
        setContentView(views.root)
        init()
    }


    private fun init(){
        views.apply {
            btn.setOnClickListener {
                mainRepository.login(
                    usernameEt.text.toString(),passwordEt.text.toString()
                ){ isDone, reason ->
                    if (!isDone){
                        Toast.makeText(this@LoginActivity, reason, Toast.LENGTH_SHORT).show()
                    }else{
                        //start moving to our main activity
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java).apply {
                            putExtra("username",usernameEt.text.toString())
                        })
                    }
                }
            }
        }
    }
}