package com.example.templatepage.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NewsCategoryDAO {
    @Insert
    fun insert(news: NewsCategory)

    @Update
    fun update(news: NewsCategory)

    @Query("SELECT * from news_category_table WHERE newsId = :key")
    fun get(key: Long): NewsCategory?

    @Query("DELETE FROM news_category_table")
    fun clear()

    @Query("SELECT * FROM news_category_table ORDER BY newsId ASC")
    fun getAllNews(): LiveData<List<NewsCategory>>
}