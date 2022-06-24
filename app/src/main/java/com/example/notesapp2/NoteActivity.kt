package com.example.notesapp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NoteActivity: AppCompatActivity() {
    lateinit var button : Button
    lateinit var title : EditText
    lateinit var description: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes_activity)
        button = findViewById(R.id.submit)
        title = findViewById(R.id.title)
        description = findViewById(R.id.description)
        button.setOnClickListener{
             val intent = Intent()
            intent.putExtra("title",title.text.toString())
            intent.putExtra("description", description.text.toString())
            setResult(RESULT_CODE,intent)
            finish()
        }
    }

    companion object {
        const val RESULT_CODE = 2
    }
}