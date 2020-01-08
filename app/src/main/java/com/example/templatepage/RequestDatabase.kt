package com.example.assignment

import android.app.DownloadManager
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Request::class],version = 1)
abstract class RequestDatabase: RoomDatabase() {
    abstract fun requestDAO() : RequestDAO
}