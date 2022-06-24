package com.example.notesapp2

import android.app.Application

class NotesApplication : Application(){
    val database by lazy {WordRoomDatabase.getDatabase(this)}
    val repository by lazy{NoteRepository(database.wordDao())}
}