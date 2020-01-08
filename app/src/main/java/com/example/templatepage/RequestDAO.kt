package com.example.templatepage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RequestDAO {
    @Insert
    fun insert(request: Request)

    @Update
    fun update(request: Request)

    @Query("SELECT * from Request")
    fun readRequest() : List<Request>

    @Query("SELECT * from Request WHERE id = :key")
    fun get(key: Long): Request?

    @Query("DELETE FROM Request")
    fun clear()

    @Query("SELECT * FROM Request ORDER BY id DESC LIMIT 1")
    fun getRequest(): Request?


}