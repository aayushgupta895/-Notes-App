package com.example.notesapp2

import android.provider.UserDictionary
import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.concurrent.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note_table ORDER  BY id ASC")
          fun getAlphabetizedNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend   fun insertInNotes(note: Note)


    @Delete
    suspend   fun deleteNote(note:Note)

}