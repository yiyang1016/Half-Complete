package com.example.templatepage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Report::class],version = 1)
abstract class ReportDatabase: RoomDatabase() {
    abstract fun reportDAO() : ReportDAO
}
