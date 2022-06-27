package com.example.notesapp2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class TitleItem : AppCompatActivity() {
    private lateinit var titleViewDescription: TextView
    private lateinit var titleViewTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.title_view)
        titleViewTitle = findViewById(R.id.title_view_title)
        titleViewDescription = findViewById(R.id.title_view_description)
        val intent = intent
        titleViewTitle.text= intent.getStringExtra("titleItem").toString()
        titleViewDescription.text = intent.getStringExtra("descItem").toString()

    }
}