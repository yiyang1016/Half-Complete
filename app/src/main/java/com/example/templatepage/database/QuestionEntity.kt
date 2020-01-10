package com.example.templatepage.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "game_table")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    val quizID: Long = 0L,

    @ColumnInfo(name = "question_str")
    val questionStr: String,

    @ColumnInfo(name = "question_img")
    var questionImg: Int,

    @ColumnInfo(name = "question_ans")
    var questionAns: String

)