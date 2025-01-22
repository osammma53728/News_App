package com.example.routeprojects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var email: String,
    var password: String
)
