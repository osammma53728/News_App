package com.example.routeprojects

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.routeprojects.databinding.CreateAccountBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreatNewAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding: CreateAccountBinding?=null
        binding= CreateAccountBinding.inflate(layoutInflater)
        setContentView(binding?.root)




        binding?.submitbtn?.setOnClickListener {
            GlobalScope.launch {
                DatabaseInstance.getDataBase(baseContext).userDao().insertUser(
                    User(
                        0,
                        binding?.name?.text.toString(),
                        binding?.passwordCreateNewAccount?.text.toString()
                    )
                )
            }
        }

    }
}