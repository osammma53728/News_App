package com.example.routeprojects

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.routeprojects.databinding.ActivityMainBinding
import com.example.routeprojects.databinding.ActivitySignInBinding
import com.example.routeprojects.databinding.CreateAccountBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    var binding:ActivitySignInBinding ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.createAccountbtn?.setOnClickListener {
            startActivity(Intent(this, CreatNewAccount::class.java))
        }
        var user: User? = null
        binding?.signbtn?.setOnClickListener {
            val email = "agg"
            val password = binding?.password?.text.toString()

               runBlocking(Dispatchers.IO) {

                    user = DatabaseInstance.getDataBase(baseContext).userDao().getUserByEmail(email)



                   }
            Toast.makeText(baseContext, user?.password, Toast.LENGTH_SHORT).show()
        }



        }
    }
