package com.example.templatepage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ScheduleCategory(
    @PrimaryKey(autoGenerate = true)
    var cityId: Long = 0L,

    @ColumnInfo(name = "city_name")
    var cityName: String = "",

    @ColumnInfo(name = "city_type")
    var cityType: String = ""

)