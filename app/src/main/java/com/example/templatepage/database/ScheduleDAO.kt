package com.example.templatepage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ScheduleDAO {

    @Insert
    fun insert(schedule: ScheduleCategory)

    @Update
    fun update(schedule: ScheduleCategory)

    @Query("SELECT * from schedulecategory WHERE cityId = :key")
    fun get(key: Long): ScheduleCategory?

    @Query("DELETE FROM schedulecategory")
    fun clear()

//    @Query("SELECT * FROM schedulecategory ORDER BY cityId ASC")
//    fun getAllSchedule(): LiveData<List<ScheduleCategory>>
}