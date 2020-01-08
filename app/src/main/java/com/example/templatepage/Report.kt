package com.example.templatepage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Report(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "address")
    var address: String = "",

    @ColumnInfo(name = "comment")
     var comment: String = ""
    )