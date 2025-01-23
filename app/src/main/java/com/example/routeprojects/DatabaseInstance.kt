package com.example.routeprojects

import android.content.Context
import androidx.room.Room

object DatabaseInstance {
    @Volatile
    private var INSTANCE:MyDatabase?=null

    fun getDataBase(context:Context):MyDatabase{
        return INSTANCE ?: synchronized(this){
            val instance= Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java,
                "user_database"
            ).build()
            INSTANCE=instance
            instance

        }

    }
}