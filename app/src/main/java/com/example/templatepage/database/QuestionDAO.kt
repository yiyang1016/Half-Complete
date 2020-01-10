package com.example.templatepage.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.templatepage.database.QuestionEntity

@Dao
interface QuestionDAO {

    @Insert
    fun insert(quiz: QuestionEntity)

    @Update
    fun update(quiz: QuestionEntity)

    @Query("SELECT * from game_table WHERE quizID = :key")
    fun get(key: Long): QuestionEntity?

    @Query("DELETE FROM game_table")
    fun clear()

    @Query("SELECT * FROM game_table ORDER BY quizID ASC")
    fun getAllQuiz(): LiveData<List<QuestionEntity>>


}