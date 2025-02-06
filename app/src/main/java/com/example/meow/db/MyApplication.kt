package com.example.meow.db

import android.app.Application

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize the database
        DataBase.init(this)

    }

}