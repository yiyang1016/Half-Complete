package com.example.templatepage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news_category_table")
data class NewsCategory(
    @PrimaryKey(autoGenerate = true)
    var newsId: Long = 0L,

    @ColumnInfo(name = "news_name")
    val newsName: String,

    @ColumnInfo(name = "news_type")
    var newsType: String

)