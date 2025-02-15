package com.example.graduation.doctor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.graduation.R
import com.example.graduation.databinding.ActivityBottomnavigationbarBinding

class BottomNavigationBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomnavigationbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomnavigationbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Doctor_profile())



        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.profile -> replaceFragment(Doctor_profile())
                R.id.chats -> replaceFragment(Doctor_chats())
                R.id.patient -> replaceFragment(Doctor_patients())
                R.id.add_times -> replaceFragment(Doctor_availableAppointments())

                else ->{


                }
            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManger = supportFragmentManager
        val framentTransaction = fragmentManger.beginTransaction()
        framentTransaction.replace(R.id.frame_layout,fragment)
        framentTransaction.commit()
    }
}