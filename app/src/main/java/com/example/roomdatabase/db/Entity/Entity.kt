package com.example.roomdatabase.db.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roomdatabase.db.DbHandler

@Entity(tableName = DbHandler.USER_TABLE)
data class EntitiUser(

    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    @ColumnInfo var name: String = "",
    @ColumnInfo var phone:String =  ""
)
