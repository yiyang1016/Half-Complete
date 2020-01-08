package com.example.templatepage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ReportDAO {
    @Insert
    fun insert(report: Report)

    @Update
    fun update(report: Report)

    @Query("SELECT * from Report")
    fun readRequest() : List<Report>

    @Query("SELECT * from Report WHERE id = :key")
    fun get(key: Long): Report?

    @Query("DELETE FROM Report")
    fun clear()

    @Query("SELECT * FROM Report ORDER BY id DESC LIMIT 1")
    fun getRequest(): Report?
}