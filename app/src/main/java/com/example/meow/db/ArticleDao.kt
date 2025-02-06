package com.example.meow.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.meow.api.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long

    @Query("SELECT * FROM Article")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("SELECT EXISTS(SELECT 1 FROM Article WHERE id = :articleId)")
    suspend fun isArticleExists(articleId: String): Boolean

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertArticle(article: Article)

}