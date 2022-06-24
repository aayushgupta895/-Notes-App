package com.example.notesapp2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note_table")
data class Note(
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "description") val desc: String){

    @PrimaryKey(autoGenerate = true) var id = 0
}
