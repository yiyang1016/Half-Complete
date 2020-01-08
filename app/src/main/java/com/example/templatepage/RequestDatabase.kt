package com.example.templatepage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.templatepage.Request

@Database(entities = [Request::class],version = 1)
abstract class RequestDatabase: RoomDatabase() {
    abstract fun requestDAO() : RequestDAO
}
