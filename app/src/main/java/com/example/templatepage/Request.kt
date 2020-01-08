package com.example.assignment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class Request(
    @PrimaryKey(autoGenerate = true)
    var  id: Int = 0,

    @ColumnInfo(name = "address")
    var address: String = "",

    @ColumnInfo(name = "no")
    var no: String = "",

    @ColumnInfo(name = "date")
    var date: String = ""
)
//){
//    @Ignore
//    constructor(address: String, no: String) : this(0, address, no)
//}
