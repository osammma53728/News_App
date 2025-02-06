package com.example.meow.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.meow.api.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        const val DATABASE_NAME = "article_db"

              @Volatile
        private var INSTANCE: DataBase? = null

        fun init(context: Context): DataBase {
            return INSTANCE ?: synchronized(this) {
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java, // Correct class name
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
        fun getInstance():DataBase?{
          return  INSTANCE
        }

    }
}
