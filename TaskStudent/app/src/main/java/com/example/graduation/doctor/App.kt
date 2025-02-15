package com.example.graduation.doctor

import android.app.Application
import com.example.graduation.utils.MySharedPreferences

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MySharedPreferences.init(this)
    }
}